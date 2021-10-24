package com.Case.constructworker.business;


import com.Case.constructworker.dataAcces.WorksiteDao;
import com.Case.constructworker.entities.Worksite;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class WorksiteManager implements WorksiteService {

    private WorksiteDao worksiteDao;

    @Autowired
    public WorksiteManager(WorksiteDao worksiteDao) {
        this.worksiteDao = worksiteDao;
    }


    @Override
    public List<Worksite> getAll() {
        return this.worksiteDao.findAll();
    }

    @Override
    public HttpStatus add(Worksite worksite) {
        try {
            this.worksiteDao.save(worksite);
            return HttpStatus.CREATED;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return HttpStatus.INTERNAL_SERVER_ERROR;

        }


    }
}

