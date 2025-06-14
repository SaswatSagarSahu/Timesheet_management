package com.timesheet.management.dao.impl;

import com.timesheet.management.Exception.TimeSheetException;
import com.timesheet.management.dao.TimesheetReportDao;
import com.timesheet.management.dto.ProjectSummaryDTO;
import com.timesheet.management.repository.TimesheetRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j(topic = "TimesheetReportDaoImpl")
public class TimesheetReportDaoImpl implements TimesheetReportDao {

    @Autowired
    private TimesheetRepository timesheetRepository;

    @Override
    public List<ProjectSummaryDTO> fetchTimeSheetSummaryReport(int projectId) throws TimeSheetException {
        log.info("Try to fetch the summary report for the project id : {}", projectId);
        try {
            return timesheetRepository.getProjectSummary(projectId);
        } catch (Exception e) {
            log.error("An error occurred while fetching the summary report for the projectId {}", projectId, e);
            throw new TimeSheetException("An error occurred while fetching the summary report for the projectId", 500);
        }
    }
}
