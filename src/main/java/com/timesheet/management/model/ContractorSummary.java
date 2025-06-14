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
public class ContractorSummary {
    private int contractorId;
    private String contractorName;

    private List<WeeklySummary> weeklySummaries;
}
