package com.Case.constructworker.dataAcces;



import com.Case.constructworker.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface WorkerDao extends CrudRepository<Worker,Integer> { //We declare  primary key  type and entity which we use for querys.Its create a generic instance  repository class   automaticly create sesion factory and send querys to database
                                                                    //Crude repository includes dlete by id

    @Query("select w from Worker w where w.worksite.id = ?1")//This annotatin  provide this metod send query to orm.JpaRepository doesn't have these querys inside it
    List<Worker> getByWorksite_Id(int worksite_ID);



    @Query("select w from Worker w where w.company_ID = ?1 and w.worksite_ID = ?2")
    List<Worker> getByCompany_IDAndWorksite_ID(int company_ID, int worksite_ID);


}
