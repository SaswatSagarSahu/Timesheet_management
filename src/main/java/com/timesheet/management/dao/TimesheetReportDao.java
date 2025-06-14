package com.timesheet.management.dao;

import com.timesheet.management.Exception.TimeSheetException;
import com.timesheet.management.dto.ProjectSummaryDTO;

import java.util.List;

public interface TimesheetReportDao {

    List<ProjectSummaryDTO> fetchTimeSheetSummaryReport(int projectId) throws TimeSheetException;
}
