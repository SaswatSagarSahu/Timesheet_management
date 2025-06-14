package com.timesheet.management.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ProjectActivities")
public class ProjectActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "activity_code", nullable = false)
    private Activity activity;

}
