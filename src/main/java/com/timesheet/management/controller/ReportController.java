package com.timesheet.management.controller;

import com.timesheet.management.model.BaseResponse;
import com.timesheet.management.usecase.ReportSummaryUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/reports")
public class ReportController {

    @Autowired
    private ReportSummaryUseCase reportSummaryUseCase;

    @GetMapping("/summary")
    public ResponseEntity<?> getProjectSummary(
            @RequestParam Integer projectId) {
        ReportSummaryUseCase.TimesheetReportResponse reportResponse = reportSummaryUseCase.execute(projectId);

        if (reportResponse.isStatus()) {
            return ResponseEntity.ok(reportResponse.getSummary());
        }

        HttpStatus httpStatus = switch (reportResponse.getErrorCode()) {
            case E_002 -> HttpStatus.BAD_REQUEST;
            case S_001 -> HttpStatus.OK;
            case E_001, E_003 -> HttpStatus.INTERNAL_SERVER_ERROR;
        };

        return ResponseEntity.status(httpStatus).contentType(MediaType.APPLICATION_JSON)
                .body(new BaseResponse(false, reportResponse.getMessage()));
    }
}
