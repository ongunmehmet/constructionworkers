package com.Case.constructworker.business;



import com.Case.constructworker.entities.Worker;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

public interface WorkerService {        //i add wanted methits to interface
    Iterable<Worker> getAll();              //a method returs worker lisr

    HttpStatus add (Worker worker);        // a add method returs HTTP status

    HttpStatus deletebyID (int ID); //

    Optional<Worker> getbyID (int ID);  //We turn Worker object to optional object for easy managment for null value

    List<Worker> getByWorksite_ID(int worksite_ID);

    List<Worker> getByCompany_IDAndWorksite_ID(int company_ID,int worksite_ID);



}
