package com.timesheet.management.service;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.timesheet.management.TimesheetManagementApplication;
import com.timesheet.management.entity.Timesheet;
import com.timesheet.management.entity.User;
import com.timesheet.management.repository.TimesheetRepository;

@Service
public class ApprovalService {

    private final TimesheetManagementApplication timesheetManagementApplication;
	
	@Autowired TimesheetRepository tsRepo;

    ApprovalService(TimesheetManagementApplication timesheetManagementApplication) {
        this.timesheetManagementApplication = timesheetManagementApplication;
    }

    @Transactional
    public Timesheet approve(User tsId, String comment) {
        Timesheet ts = tsRepo.findById(tsId).orElseThrow();
        if (ts.getStatus() != Timesheet.Status.SUBMITTED)
            throw new IllegalStateException("Only SUBMITTED can be approved");
        ts.getStatus(Timesheet.Status.APPROVED);
        ts.setManagerComment(comment);
        return tsRepo.save(ts);
    }
    
    @Transactional
    public Timesheet reject(User tsId, String comment) {
        Timesheet ts = tsRepo.findById(tsId).orElseThrow();
        if (ts.getStatus() != Timesheet.Status.SUBMITTED)
            throw new IllegalStateException("Only SUBMITTED can be rejected");
        if (comment == null || comment.isBlank())
            throw new IllegalArgumentException("Manager comment is required on reject");
        ts.setStatus(Timesheet.Status.REJECTED);
        ts.setManagerComment(comment);
        return tsRepo.save(ts);
    }

    public List<Timesheet> getPending() {
        return tsRepo.findByStatus(Timesheet.Status.SUBMITTED);
    }
    
}
