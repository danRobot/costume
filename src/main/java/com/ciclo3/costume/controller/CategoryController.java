/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo3.costume.controller;

import com.ciclo3.costume.service.CategoryService;
import com.ciclo3.costume.model.Category;
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
@RequestMapping("/api/Category")
@CrossOrigin
public class CategoryController {
    @Autowired
    private CategoryService clientService;
    @GetMapping("/all")
    public List<Category> getAll(){
        return clientService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Category> getCostume(@PathVariable int id){
        return clientService.getCategory(id);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Category save(@RequestBody Category costume){
        return clientService.save(costume);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Category updateCostume(@RequestBody Category costume){
        return clientService.update(costume);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deteleCostume(@PathVariable int id){
        return clientService.deleteCategory(id);
    }
    @DeleteMapping("/all")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deteleAllCostumes(){
        return clientService.deleteAll();
    }
}
