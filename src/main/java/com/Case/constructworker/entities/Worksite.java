package com.Case.constructworker.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.List;

@Data
@Entity
@Table(name = "worksites")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","workers"})
public class Worksite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "worksite_ID")
    private int id;

    @Column(name ="worksite_Name", nullable = false)
    private String name;

    @Column(name = "woksite_City", nullable = false)
    private String city;

    @OneToMany(targetEntity=Worker.class, mappedBy="id",cascade=CascadeType.ALL, fetch = FetchType.LAZY)

    private List<Worker> workers ;
}
