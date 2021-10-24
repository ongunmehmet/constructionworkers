package com.Case.constructworker.business;



import com.Case.constructworker.dataAcces.CompanyDao;
import com.Case.constructworker.entities.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CompanyManager implements CompanyService {

    private CompanyDao companyDao;
    @Autowired

    public CompanyManager(CompanyDao companyDao) {
        this.companyDao = companyDao;
    }

    @Override
    public List<Company> getAll() {
        return this.companyDao.findAll();
    }

    @Override

    public HttpStatus add(Company company) {
        try {
            this.companyDao.save(company);
            return HttpStatus.CREATED;

        }catch (Exception e){
            System.out.println(e.getMessage());
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }

    }



    }

