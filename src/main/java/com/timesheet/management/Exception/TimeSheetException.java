package com.timesheet.management.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class TimeSheetException extends Exception{

    private String message;
    private int errorCode;
}
