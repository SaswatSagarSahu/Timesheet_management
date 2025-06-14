package com.timesheet.management.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TimesheetReportSummary {
    private int projectId;
    private String projectName;
    private String client;
    private Status status;

    private List<ContractorSummary> contractorSummaries;
}
