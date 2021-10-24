package com.Case.constructworker.business;



import com.Case.constructworker.dataAcces.WorkerDao;
import com.Case.constructworker.entities.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service// Its declare this calss is service class

public class WorkerManager implements WorkerService {

    private WorkerDao workerDao;
    @Autowired//Spring finds an instance for workerdao and WorkerDao creates generic instance
    public WorkerManager(WorkerDao workerDao) {
        this.workerDao = workerDao;}//Dependency injection withConstructor injection

    @Override
    public List<Worker> getAll() {
        return (List<Worker>) this.workerDao.findAll(); //find all is method iterable in cruderepository so we turn to list it with type casting
    }

    @Override
    public HttpStatus add(Worker worker) { //it add a new worker object .it calls save method in worker dao.If it succesful it returns  http created.
                                            //If it fails retur internal server error
                                            //I didn't have enough time to handele exeption part more detailet.I know that i should use more specific exception types.
        try {
            this.workerDao.save(worker);
            return HttpStatus.CREATED;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return HttpStatus.INTERNAL_SERVER_ERROR;

        }


    }

    @Override
    public HttpStatus deletebyID(int id) {   //it delete objets by id.
        try {
            this.workerDao.deleteById(id);
            return HttpStatus.ACCEPTED;

        }catch (Exception e){
            System.out.println(e.getMessage());
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }


    }

    @Override
    public Optional<Worker> getbyID(int id) {

        return this.workerDao.findById(id);


    }

    @Override
    public List<Worker> getByWorksite_ID(int worksite_ID) {
        return this.workerDao.getByWorksite_Id(worksite_ID);
    }

    @Override
    public List<Worker> getByCompany_IDAndWorksite_ID(int company_ID, int worksite_ID) {
        return this.workerDao.getByCompany_IDAndWorksite_ID(company_ID,worksite_ID);
    }


}



