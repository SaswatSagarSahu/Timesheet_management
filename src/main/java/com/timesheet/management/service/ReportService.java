package com.timesheet.management.service;

import com.timesheet.management.dto.ProjectSummaryDTO;
import com.timesheet.management.model.ContractorSummary;
import com.timesheet.management.model.Status;
import com.timesheet.management.model.TimesheetReportSummary;
import com.timesheet.management.model.WeeklySummary;
import com.timesheet.management.repository.TimesheetRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {

    @Autowired
    private TimesheetRepository timesheetRepository;

    public TimesheetReportSummary getProjectSummary(Integer projectId) {
        List<ProjectSummaryDTO> rawData = timesheetRepository.getProjectSummary(projectId);

        if (rawData.isEmpty()) throw new EntityNotFoundException("No data found for project ID: " + projectId);

        TimesheetReportSummary response = new TimesheetReportSummary();
        Map<Integer, ContractorSummary> contractorMap = new LinkedHashMap<>();

        ProjectSummaryDTO first = rawData.get(0);
        response.setProjectId(first.getProjectId());
        response.setProjectName(first.getProjectName());
        response.setClient(first.getClient());
        response.setStatus(first.getStatus() ? Status.ACTIVE : Status.INACTIVE);

        for (ProjectSummaryDTO dto : rawData) {
            contractorMap.computeIfAbsent(dto.getContractorId(), id -> {
                ContractorSummary cs = new ContractorSummary();
                cs.setContractorId(id);
                cs.setContractorName(dto.getContractorName());
                cs.setWeeklySummaries(new ArrayList<>());
                return cs;
            }).getWeeklySummaries().add(new WeeklySummary(
                dto.getStartDate(),
                dto.getTotalHours(),
                dto.getStatusEnum()
            ));
        }

        response.setContractorSummaries(new ArrayList<>(contractorMap.values()));
        return response;
    }
}