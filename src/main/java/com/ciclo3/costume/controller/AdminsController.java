/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo3.costume.controller;

import com.ciclo3.costume.service.AdminsService;
import com.ciclo3.costume.model.Admins;
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
@RequestMapping("/api/Admins")
@CrossOrigin
public class AdminsController {
    @Autowired
    private AdminsService clientService;
    @GetMapping("/all")
    public List<Admins> getAll(){
        return clientService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Admins> getCostume(@PathVariable int id){
        return clientService.getAdmins(id);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Admins save(@RequestBody Admins costume){
        return clientService.save(costume);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Admins updateCostume(@RequestBody Admins costume){
        return clientService.update(costume);
    }
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public boolean deteleCostume(@PathVariable int id){
        return clientService.deleteAdmins(id);
    }
    @DeleteMapping("/delete/all")
    @ResponseStatus(HttpStatus.CREATED)
    public boolean deteleAllCostumes(){
        return clientService.deleteAll();
    }
}
