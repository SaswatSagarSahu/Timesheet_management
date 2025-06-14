package com.timesheet.management.dto;

import com.timesheet.management.entity.Timesheet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectSummaryDTO {
    private Integer projectId;
    private String projectName;
    private String client;
    private Boolean status;

    private Integer contractorId;
    private String contractorName;
    private LocalDate startDate;
    private BigDecimal totalHours;
    private Timesheet.Status statusEnum;
}