package com.Case.constructworker.api;



import com.Case.constructworker.business.WorksiteService;
import com.Case.constructworker.entities.Worksite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/worksite")
public class WorksiteController {
    private WorksiteService worksiteService;

    @Autowired
    public WorksiteController(WorksiteService worksiteService) {
        this.worksiteService = worksiteService;
    }


    @GetMapping("/getall")
    public List<Worksite> getall() {
        return this.worksiteService.getAll();
    }

    @PostMapping("/add")
    public HttpStatus add(@RequestBody Worksite worksite) {
        try {
            this.worksiteService.add(worksite);
            return HttpStatus.CREATED;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return HttpStatus.INTERNAL_SERVER_ERROR;

        }
    }
}
