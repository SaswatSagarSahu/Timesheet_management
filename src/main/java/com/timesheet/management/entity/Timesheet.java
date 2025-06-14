package com.timesheet.management.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Timesheets")
@Getter
@Setter
@RequiredArgsConstructor
public class Timesheet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contractor_id", nullable = false)
    private User contractor;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status = Status.DRAFT;

    private String managerComment;

    @OneToMany(mappedBy = "timesheet", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<TimesheetEntry> entries;

    public enum Status {
        DRAFT, SUBMITTED, APPROVED, REJECTED
    }

}
