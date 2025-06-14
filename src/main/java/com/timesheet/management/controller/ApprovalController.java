package com.timesheet.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.timesheet.management.dto.CommentDto;
import com.timesheet.management.entity.Timesheet;
import com.timesheet.management.entity.User;
import com.timesheet.management.service.ApprovalService;

@RestController
@RequestMapping("/api/v1/timesheets")

public class ApprovalController {
	@Autowired ApprovalService svc;

    @GetMapping("/pending")
    public List<Timesheet> pending() {
        return svc.getPending();
    }
    
    @PutMapping("/approve/{id}")
    public Timesheet approve(@PathVariable User id, @RequestBody CommentDto dto) {
        return svc.approve(id, dto.getComment());
    }

    @PutMapping("/reject/{id}")
    public Timesheet reject(@PathVariable User id, @RequestBody CommentDto dto) {
        return svc.reject(id, dto.getComment());
    }

}
