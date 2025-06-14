package com.timesheet.management.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "Projects")
@Getter
@Setter
@RequiredArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "project_code", unique = true, nullable = false)
    private String projectCode;

    @Column(nullable = false)
    private String name;

    private String client;

    private Boolean status = true;
}
