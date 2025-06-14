package com.timesheet.management.usecase;

import com.timesheet.management.model.TimesheetReportSummary;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public interface ReportSummaryUseCase {

    TimesheetReportResponse execute(Integer projectId);

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    class TimesheetReportResponse {
        private TimesheetReportSummary summary;

        private boolean status;
        private String message;
        private TimeSheetErrorCode errorCode;
    }

    enum TimeSheetErrorCode{
        S_001,
        E_001,
        E_002,
        E_003;
    }

}
