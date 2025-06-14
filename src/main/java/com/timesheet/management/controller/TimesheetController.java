package com.timesheet.management.controller;
/**
 * REST controller for handling timesheet operations.
 * 
 * Developer: SIVA NAGA RAJU PAMARTHI
 */


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.timesheet.management.requestDTO.TimesheetRequest;
import com.timesheet.management.service.TimesheetService;
import com.timesheet.management.utils.JwtUtils;

import org.springframework.web.bind.annotation.RequestHeader;

import java.util.Map;
/**
 * REST controller for handling Timesheets operations.
 * 
 * Developer: SIVA NAGA RAJU PAMARTHI
 */

@RestController
@EnableJpaRepositories
public class TimesheetController {

    @Autowired
    private TimesheetService timesheetService;
    
    @Autowired
    private JwtUtils jwtutil;


    /**
     * Endpoint to create a new timesheet and its entries.
     * 
     * URL: POST /api/v1/timesheets
     * 
     * @param request Timesheet request payload
     * @return JSON response with created timesheet ID
     */
    @PostMapping("/api/v1/timesheets")
    public ResponseEntity<?> createTimesheet(@RequestBody TimesheetRequest request) {
        String id = timesheetService.createTimesheet(request);
        
        return ResponseEntity.ok(Map.of(
            "message", "Timesheet created successfully",
            "timesheetId", id
        ));
    }
}


//
//@PostMapping("/api/v1/timesheets")
//public ResponseEntity<?> createTimesheet1(
//        @RequestBody TimesheetRequest request,
//        @RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader) {
//
//    // Validate header
//    if (authHeader == null || !authHeader.startsWith("Bearer ")) {
//        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error", "Missing or invalid Authorization header"));
//    }
//
//    String token = authHeader.substring(7); // Remove "Bearer "
//
//    // Validate token using JwtUtil
//    if (!jwtUtil.validateToken(token)) {
//        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error", "Invalid or expired token"));
//    }
//
//    // Optionally extract info
//    String username = jwtUtil.extractUsername(token);
//    String role = jwtUtil.extractRole(token);
//    // You could check role/username here if needed
//
//    // Proceed with service logic
//    String id = timesheetService.createTimesheet(request);
//    return ResponseEntity.ok(Map.of(
//        "message", "Timesheet created successfully",
//        "timesheetId", id
//    ));
//}
