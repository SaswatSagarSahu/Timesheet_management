package com.timesheet.management.service;

import com.timesheet.management.requestDTO.TimesheetRequest;

public interface TimesheetService {

	String createTimesheet(TimesheetRequest request);

}
