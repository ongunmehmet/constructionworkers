package com.Case.constructworker.business;


import com.Case.constructworker.entities.Worksite;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface WorksiteService {
    List<Worksite> getAll();

    HttpStatus add(Worksite worksite);
}
