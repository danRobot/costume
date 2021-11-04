/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo3.costume.controller;

import com.ciclo3.costume.service.ClientService;
import com.ciclo3.costume.model.Client;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


/**
 *
 * @author danm
 */
@RestController
@RequestMapping("/api/Client")
@CrossOrigin
public class ClientController {
    @Autowired
    private ClientService clientService;
    @GetMapping("/all")
    public List<Client> getAll(){
        return clientService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Client> getCostume(@PathVariable int id){
        return clientService.getClient(id);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Client save(@RequestBody Client costume){
        return clientService.save(costume);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Client updateCostume(@RequestBody Client costume){
        return clientService.update(costume);
    }
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public boolean deteleCostume(@PathVariable int id){
        return clientService.deleteClient(id);
    }
    @DeleteMapping("/delete/all")
    @ResponseStatus(HttpStatus.CREATED)
    public boolean deteleAllCostumes(){
        return clientService.deleteAll();
    }
}
