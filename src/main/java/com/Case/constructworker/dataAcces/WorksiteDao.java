package com.Case.constructworker.dataAcces;



import com.Case.constructworker.entities.Worksite;
import org.springframework.data.jpa.repository.JpaRepository;


public interface WorksiteDao extends JpaRepository<Worksite,Integer> {
}
