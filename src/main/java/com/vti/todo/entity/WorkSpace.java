package com.vti.todo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "work_spaces")
public class WorkSpace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToOne
    private AccountEntity account;
}
