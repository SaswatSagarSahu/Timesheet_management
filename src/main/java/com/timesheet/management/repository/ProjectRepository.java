package com.timesheet.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.timesheet.management.entity.Project;
import com.timesheet.management.entity.Timesheet;
import com.timesheet.management.entity.TimesheetEntry;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
    // Add custom methods if needed, e.g.:
    // List<TimesheetEntry> findByTimesheetId(Integer timesheetId);
	
}
