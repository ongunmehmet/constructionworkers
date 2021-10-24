package com.Case.constructworker.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data //Generates getters and setters
@Entity //Defines that this cla be mapped a table
@Table(name = "workers")// it allows speciy to details of table which we use in database
@AllArgsConstructor//generates constructor with using all paramaters we declare
@NoArgsConstructor// generates default constructor
public class Worker  {

    @Id//declare this parameter declere ID
    @GeneratedValue(strategy = GenerationType.IDENTITY)// configure the way of increment of the specified column
    @Column(name = "worker_ID") //it specify which column represent in mapping
    private int id;

    @Column(name = "worker_Name",nullable = false) //this field cant be null
    private String name;

    @Column(name = "worker_Surname",nullable = false)
    private String surName;

    @Column (name ="worker_Salary",nullable = false)
    private double salary;

    @Column(name = "isManager",nullable = false)
    private boolean manager;


    @ManyToOne() //creates many to one relationship worker with company
    @JoinColumn(name="company_ID", referencedColumnName = "company_ID", insertable = false, updatable = false,nullable = false)//inserting and updating this field controeld by other table
    private Company company;
    @Column(name="company_ID") //I have to add this cloumn because spring throw error:one field doesn't have default value .I couldn't solve whatever i do.
                               // i surpass the error but this time column values turn null when i enter values
    private int company_ID;

    @ManyToOne() //creates many to one relationship worker with worksite
    @JoinColumn(name="worksite_ID", referencedColumnName = "worksite_ID", insertable = false, updatable = false,nullable = false)
    //marks a column for as a join column for an entity association or an element collection.
    private Worksite worksite ;
    @Column(name="worksite_ID")
    private int worksite_ID;






}
