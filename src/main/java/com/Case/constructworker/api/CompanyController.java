package com.Case.constructworker.api;



import com.Case.constructworker.business.CompanyService;

import com.Case.constructworker.entities.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/company")
public class CompanyController {
    private CompanyService companyService;

    @Autowired

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/getall")
    public List<Company> getall(){
        return this.companyService.getAll();
    }

    @PostMapping("/add")
    public HttpStatus add(@RequestBody Company company){
        this.companyService.add(company);
        return HttpStatus.CREATED;

    }
}
