//package com.timesheet.management.controller;
//
//import com.timesheet.management.model.TimesheetReportSummary;
//import com.timesheet.management.service.ReportService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api/v1/reports")
//public class ReportController {
//
//    @Autowired
//    private ReportService reportService;
//
//    @GetMapping("/summary")
//    public ResponseEntity<TimesheetReportSummary> getProjectSummary(
//            @RequestParam Integer projectId) {
//        return ResponseEntity.ok(reportService.getProjectSummary(projectId));
//    }
//}
