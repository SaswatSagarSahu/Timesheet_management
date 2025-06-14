package com.timesheet.management.usecase.impl;

import com.timesheet.management.Exception.TimeSheetException;
import com.timesheet.management.dao.TimesheetReportDao;
import com.timesheet.management.dto.ProjectSummaryDTO;
import com.timesheet.management.model.ContractorSummary;
import com.timesheet.management.model.Status;
import com.timesheet.management.model.TimesheetReportSummary;
import com.timesheet.management.model.WeeklySummary;
import com.timesheet.management.usecase.ReportSummaryUseCase;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Component
@AllArgsConstructor
@Slf4j(topic = "ReportSummaryUseCaseImpl")
public class ReportSummaryUseCaseImpl implements ReportSummaryUseCase {

    private TimesheetReportDao timesheetReportDao;

    @Override
    public TimesheetReportResponse execute(Integer projectId) {
        List<ProjectSummaryDTO> projectSummaryDTOS;
        try {
            projectSummaryDTOS = timesheetReportDao.fetchTimeSheetSummaryReport(projectId);
        } catch (TimeSheetException e) {
            log.error("Some error occurred while fetching the report for projectId {}", projectId);
            return buildErrorResponse("Some error occurred while fetching the report for projectId", TimeSheetErrorCode.E_001);
        }

        if (projectSummaryDTOS.isEmpty()) {
            log.error("No record found for the report for projectId {}", projectId);
            return buildErrorResponse("No Data found for projectId", TimeSheetErrorCode.E_002);
        }

        try {
            return TimesheetReportResponse.builder()
                    .status(true)
                    .message("Success")
                    .errorCode(TimeSheetErrorCode.S_001)
                    .summary(mapToTimesheetReportSummary(projectSummaryDTOS))
                    .build();
        } catch (Exception e) {
            log.error("Some error occurred while try to generate the report {}", projectId, e);
            return buildErrorResponse("Some error occurred while try to generate the report", TimeSheetErrorCode.E_003);
        }

    }

    private TimesheetReportResponse buildErrorResponse(String message, TimeSheetErrorCode errorCode){
        return TimesheetReportResponse.builder()
                .status(false)
                .message(message)
                .errorCode(errorCode)
                .build();
    }

    private TimesheetReportSummary mapToTimesheetReportSummary(List<ProjectSummaryDTO> projectSummaryDTOS) {
        TimesheetReportSummary response = new TimesheetReportSummary();
        Map<Integer, ContractorSummary> contractorMap = new LinkedHashMap<>();

        ProjectSummaryDTO first = projectSummaryDTOS.get(0);
        response.setProjectId(first.getProjectId());
        response.setProjectName(first.getProjectName());
        response.setClient(first.getClient());
        response.setStatus(first.getStatus() ? Status.ACTIVE : Status.INACTIVE);

        for (ProjectSummaryDTO dto : projectSummaryDTOS) {
            contractorMap.computeIfAbsent(dto.getContractorId(), id -> ContractorSummary.builder()
                    .contractorId(id)
                    .contractorName(dto.getContractorName())
                    .weeklySummaries(new ArrayList<>())
                    .build()).getWeeklySummaries().add(new WeeklySummary(
                    dto.getStartDate(),
                    dto.getTotalHours(),
                    dto.getStatusEnum()
            ));
        }

        response.setContractorSummaries(new ArrayList<>(contractorMap.values()));
        return response;
    }
}
