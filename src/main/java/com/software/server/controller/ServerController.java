package com.software.server.controller;

import com.software.server.model.Server;
import com.software.server.repository.ServerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class ServerController {
    @Autowired
    ServerRepository serverRepository;
    @RequestMapping(value = "/servers", method = RequestMethod.POST)
    public Server createServer(@RequestBody Server server){
        return serverRepository.save(server);
    }
    @RequestMapping(value = "/servers", method = RequestMethod.GET)
    public List<Server> readServers(){
        return serverRepository.findAll();
    }

    @RequestMapping(value = "/servers/{id}", method = RequestMethod.PUT)
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

    @RequestMapping(value = "/servers/{id}", method = RequestMethod.DELETE)
    public void deleteServers(@PathVariable(value = "id") Long id){
        serverRepository.deleteById(id);
    }

}
