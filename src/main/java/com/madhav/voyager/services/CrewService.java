package com.madhav.voyager.services;

import com.madhav.voyager.models.Crew;
import com.madhav.voyager.repositories.CrewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CrewService {

    @Autowired
    private CrewRepository repository;

    public List<Crew> getAllCrew(){
        return repository.findAll();
    }

    public Crew getCrew(Integer id){
        return repository.findById(id).get();
    }

    public Crew saveCrew(Crew crew){
        return repository.save(crew);
    }
}
