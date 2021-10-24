package com.Case.constructworker.dataAcces;



import com.Case.constructworker.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CompanyDao extends JpaRepository<Company,Integer> {
}
