package com.timesheet.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.timesheet.management.entity.Activity;
import com.timesheet.management.entity.Project;
import com.timesheet.management.entity.Timesheet;
import com.timesheet.management.entity.TimesheetEntry;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Integer> {
    // Add custom methods if needed, e.g.:
    // List<TimesheetEntry> findByTimesheetId(Integer timesheetId);
	
}
