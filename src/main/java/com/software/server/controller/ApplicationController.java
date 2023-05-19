package com.software.server.controller;

import com.software.server.model.Application;
import com.software.server.model.Server;
import com.software.server.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ApplicationController {
    @Autowired
    ApplicationRepository applicationRepository;

    @RequestMapping(value = "/applications", method = RequestMethod.POST)
    public Application createApplication(@RequestBody Application server){
        return applicationRepository.save(server);
    }
    @RequestMapping(value = "/applications", method = RequestMethod.GET)
    public List<Application> readApplications(){
        return applicationRepository.findAll();
    }

    @RequestMapping(value = "/applications/{id}", method = RequestMethod.PUT)
    public Application updateApplication(@PathVariable(value = "id") Long id, @RequestBody Application application){

        Application foundApplication = applicationRepository.findById(id).get();

        foundApplication.setName(application.getName());
        foundApplication.setVersion(application.getVersion());

        applicationRepository.save(foundApplication);

        return foundApplication;
    }

    @RequestMapping(value = "/applications/{id}", method = RequestMethod.DELETE)
    public void deleteApplication(@PathVariable(value = "id") Long id){
        applicationRepository.deleteById(id);
    }

}
