package com.vti.todo.entity;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@Table(name = "tasks")
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    @ManyToOne
    private TaskStatus taskStatus;

    private String description;

    private LocalDate startDate;

    private LocalDate dueDate;

    @ManyToOne
    private WorkSpace workSpace;
}
