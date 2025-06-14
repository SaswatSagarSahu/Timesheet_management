package com.timesheet.management.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.timesheet.management.entity.Activity;
import com.timesheet.management.entity.Project;
import com.timesheet.management.entity.Timesheet;
import com.timesheet.management.entity.TimesheetEntry;
import com.timesheet.management.repository.ActivityRepository;
import com.timesheet.management.repository.ProjectRepository;
import com.timesheet.management.repository.TimesheetEntryRepository;
import com.timesheet.management.repository.TimesheetRepository;
import com.timesheet.management.entity.Timesheet.Status;
import com.timesheet.management.requestDTO.TimesheetEntryRequest;
import com.timesheet.management.requestDTO.TimesheetRequest;

/**
 * REST controller for handling Timesheets operations.
 * 
 * Developer: SIVA NAGA RAJU PAMARTHI
 */
@Service
public class TimesheetServiceImpl implements TimesheetService  {

	
    @Autowired
    private TimesheetRepository timesheetRepo;

	
    @Autowired
    private TimesheetEntryRepository entryRepo;
	
    @Autowired
    private ProjectRepository projRepo;
	
    @Autowired
    private ActivityRepository activityRepo;
    
    @Override
    public String createTimesheet(TimesheetRequest request) {
    	
    	try {
    	Timesheet timesheet = new Timesheet();
    	LocalDate startDate = LocalDate.parse(request.getStartDate());
        timesheet.setStartDate(startDate);
        timesheet.setStatus(Status.DRAFT);

        Timesheet savedTimesheet = timesheetRepo.save(timesheet);

        for (TimesheetEntryRequest entryReq : request.getEntries()) {
            TimesheetEntry entry = new TimesheetEntry();
            Project proj=projRepo.getById(entryReq.getProjectId());
            Activity activity=activityRepo.getById(entryReq.getActivityCode());
            entry.setTimesheet(savedTimesheet);
            entry.setProject(proj);
            entry.setActivity(activity);
            entry.setDate(entryReq.getDate());
            entry.setHoursWorked(entryReq.getHoursWorked());
            entry.setComments(entryReq.getComments());

            entryRepo.save(entry);
         }
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
        return "saved";
    }
}

