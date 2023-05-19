package com.software.server.controller;

import com.software.server.model.Application;
import com.software.server.repository.ApplicationRepository;
import com.software.server.repository.ApplicationSpecifications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ApplicationController {
    @Autowired
    ApplicationRepository applicationRepository;

    @PostMapping("/applications")
    public Application createApplication(@RequestBody Application server){
        return applicationRepository.save(server);
    }
    @GetMapping("/applications")
    public List<Application> readApplications(){
        return applicationRepository.findAll();
    }

    @PutMapping("/applications/{id}")
    public Application updateApplication(@PathVariable(value = "id") Long id, @RequestBody Application application){

        Application foundApplication = applicationRepository.findById(id).get();

        foundApplication.setName(application.getName());
        foundApplication.setVersion(application.getVersion());

        applicationRepository.save(foundApplication);

        return foundApplication;
    }

    @DeleteMapping("/applications/{id}")
    public void deleteApplication(@PathVariable(value = "id") Long id){
        applicationRepository.deleteById(id);
    }

    @GetMapping("/applications/{name}")
    public List<Application> findApplicationByName(
        @PathVariable(value = "name") String name
        ){
            List<Application> list = applicationRepository.findAll(
                ApplicationSpecifications.getApplicationByName(name)
            );

            return list;
    }

}
