package com.Case.constructworker.business;

import com.Case.constructworker.entities.Company;

import org.springframework.http.HttpStatus;

import java.util.List;

public interface CompanyService {

        List<Company> getAll();

        HttpStatus add (Company company);
}
