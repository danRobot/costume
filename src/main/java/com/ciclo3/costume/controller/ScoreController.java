/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo3.costume.controller;

import com.ciclo3.costume.service.ScoreService;
import com.ciclo3.costume.model.Score;
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
@RequestMapping("/api/Score")
@CrossOrigin
public class ScoreController {
    @Autowired
    private ScoreService scoreService;
    
    @GetMapping("/all")
    public List<Score> getAll(){
        return scoreService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Score> getCostume(@PathVariable int id){
        return scoreService.getScore(id);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Score save(@RequestBody Score costume){
        return scoreService.save(costume);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Score updateCostume(@RequestBody Score costume){
        return scoreService.update(costume);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deteleCostume(@PathVariable int id){
        return scoreService.deleteScore(id);
    }
    @DeleteMapping("/all")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deteleAllCostumes(){
        return scoreService.deleteAll();
    }
}
