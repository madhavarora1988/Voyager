package com.madhav.voyager.controllers;

import com.madhav.voyager.models.Crew;
import com.madhav.voyager.services.CrewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CrewController {

    @Autowired
    private CrewService service;

    @GetMapping("/crew")
    public List<Crew> getAllCrew(){
        return service.getAllCrew();

    }

    @GetMapping("/crew/{id}")
    public Crew getCrew(@PathVariable Integer id){
        return service.getCrew(id);
    }

    @PostMapping("/crew")
    public Crew postCrew(@RequestBody Crew crew){
        return service.saveCrew(crew);
    }
}
