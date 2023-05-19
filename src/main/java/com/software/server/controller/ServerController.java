package com.software.server.controller;

import com.software.server.model.Server;
import com.software.server.repository.ServerRepository;
import com.software.server.repository.ServerSpecifications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class ServerController {

    @Autowired
    ServerRepository serverRepository;

    @PostMapping("/servers")
    public Server createServer(@RequestBody Server server){
        return serverRepository.save(server);
    }

    @GetMapping("/servers")
    public List<Server> readServers(){
        return serverRepository.findAll();
    }

    @PutMapping("/servers/{id}")
    public Server readServers(@PathVariable(value = "id") Long id, @RequestBody Server server){

        Server foundServer = serverRepository.findById(id).get();

        foundServer.setDisk(server.getDisk());
        foundServer.setIp(server.getIp());
        foundServer.setName(server.getName());
        foundServer.setMemory(server.getMemory());
        foundServer.setLocation(server.getLocation());
        foundServer.setLocation(server.getLocation());
        foundServer.setProcessor(server.getProcessor());
        foundServer.setOperatingSystem(server.getOperatingSystem());

        serverRepository.save(foundServer);

        return foundServer;
    }

    @DeleteMapping("/servers/{id}")
    public void deleteServers(@PathVariable(value = "id") Long id){
        serverRepository.deleteById(id);
    }

    @GetMapping("/servers/{operatingSystem}")
    public List<Server> findServerByOperatingSystem(
        @PathVariable(value = "operatingSystem") String operatingSystem
        ){
            List<Server> list = serverRepository.findAll(
                ServerSpecifications.getServerByOperatingSystem(operatingSystem)
            );

            return list;
    }

    @GetMapping("/serversWithMultipleApplications")
    public List<Server> getServerWithMultipleApplications(){

        return serverRepository.findAll(
                ServerSpecifications.getServerWithMultipleApplication()
        );
    }

}
