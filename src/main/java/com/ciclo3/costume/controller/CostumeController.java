/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo3.costume.controller;

import com.ciclo3.costume.service.CostumeService;
import com.ciclo3.costume.model.Costume;
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
@RequestMapping("/api/Costume")
@CrossOrigin
public class CostumeController {
    @Autowired
    private CostumeService costumeService;
    
    @GetMapping("/all")
    public List<Costume> getAll(){
        return costumeService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Costume> getCostume(@PathVariable int id){
        return costumeService.getCostume(id);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Costume save(@RequestBody Costume costume){
        return costumeService.save(costume);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Costume updateCostume(@RequestBody Costume costume){
        return costumeService.update(costume);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deteleCostume(@PathVariable int id){
        return costumeService.deleteCostume(id);
    }
    @DeleteMapping("/all")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deteleAllCostumes(){
        return costumeService.deleteAll();
    }
}
