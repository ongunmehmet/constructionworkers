package com.Case.constructworker.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "companies")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","workers"}) // i added this annotation because  getall method gets into a loop
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_ID")
    private int id;

    @Column(name ="company_Name",nullable = false)
    private String name;

    @OneToMany(targetEntity=Worker.class, mappedBy="id",cascade=CascadeType.ALL, fetch = FetchType.LAZY)//it create one to many relation ship.
                                                                                                        //Cascade if you change any data about an entitty it automaticly chance others table

    private List<Worker> workers;
}
