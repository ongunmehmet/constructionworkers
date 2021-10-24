package com.Case.constructworker.api;



import com.Case.constructworker.business.WorkerService;
import com.Case.constructworker.entities.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController                          //It  declare this class is restcontroller.It returns answers to request which sended by url.
@RequestMapping("/api/worker")       //it maps to a request an http adress  on class level
public class WorkerController {

    private WorkerService workerService;
    @Autowired
    public WorkerController(WorkerService workerService) {
        this.workerService = workerService;
    }


    @GetMapping("/getall")   // It recive get request from  /worker/getall and  send it to worker service
    public List<Worker> getall(){
        return (List<Worker>) this.workerService.getAll(); //it returns incoming data in JSON format as response to UI

    }
    @GetMapping(value = "/getbyid") //It recive id parametar and return response an worker object  to request
    public Optional<Worker> getByID(@RequestParam int id){

        return this.workerService.getbyID(id);
    }



    @PostMapping("/add")         //It send data with body to url for add to database.RequestMethot.Post shortcut
    public HttpStatus add(@RequestBody Worker worker){
        return this.workerService.add(worker);


    }
    @DeleteMapping(path="/delete/{id}") //It delete object from url path variable
    public HttpStatus deleteById(@PathVariable int id) {
        return this.workerService.deletebyID(id);


    }
    @GetMapping("/getbyworksiteid")
    public List<Worker> getByWorksite_Id(@RequestParam int worksite_ID) {
        return this.workerService.getByWorksite_ID( worksite_ID);}

    @GetMapping("/getbyworsiteidandcompanyid")
    public List<Worker> getByCompany_IDAndWorksite_ID(@RequestParam int company_ID,@RequestParam int worksite_ID) {
        return this.workerService.getByCompany_IDAndWorksite_ID(company_ID, worksite_ID);
    }



}
