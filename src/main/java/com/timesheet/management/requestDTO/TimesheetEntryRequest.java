package com.timesheet.management.requestDTO;

import java.time.LocalDate;

/**
 * class representing a TimesheetEntryRequest.
 * 
 * Developer: SIVA NAGA RAJU PAMARTHI
 */

public class TimesheetEntryRequest {
    private Integer projectId;
    private Integer activityCode;
    private LocalDate date;
    private Integer hoursWorked;
    private String comments;
	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	public Integer getActivityCode() {
		return activityCode;
	}
	public void setActivityCode(Integer activityCode) {
		this.activityCode = activityCode;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public Integer getHoursWorked() {
		return hoursWorked;
	}
	public void setHoursWorked(Integer hoursWorked) {
		this.hoursWorked = hoursWorked;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}

}

