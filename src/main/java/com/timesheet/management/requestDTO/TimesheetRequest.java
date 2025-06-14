package com.timesheet.management.requestDTO;

import java.util.List;

import com.timesheet.management.entity.Timesheet.Status;

import lombok.Getter;
import lombok.Setter;
/**
 * This is for representing a TimesheetRequest.
 * 
 * Developer: SIVA NAGA RAJU PAMARTHI
 */
@Getter
@Setter
public class TimesheetRequest {
    private String startDate;
    private String status;
    private List<TimesheetEntryRequest> entries;
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<TimesheetEntryRequest> getEntries() {
		return entries;
	}
	public void setEntries(List<TimesheetEntryRequest> entries) {
		this.entries = entries;
	}

    
}
