package com.timesheet.management.model;

import com.timesheet.management.entity.Timesheet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WeeklySummary {

    private LocalDate startDate;
    private BigDecimal totalHours;
    private Timesheet.Status status;

}
