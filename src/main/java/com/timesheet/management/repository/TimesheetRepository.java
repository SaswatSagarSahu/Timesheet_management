package com.timesheet.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.timesheet.management.entity.Timesheet;

@Repository
public interface TimesheetRepository extends JpaRepository<Timesheet, Integer> {
    // Add custom methods if needed, e.g.:
    // List<TimesheetEntry> findByTimesheetId(Integer timesheetId);
	
}
