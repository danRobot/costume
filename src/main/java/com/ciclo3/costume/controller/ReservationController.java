/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo3.costume.controller;

import com.ciclo3.costume.service.ReservationService;
import com.ciclo3.costume.model.Reservation;
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
@RequestMapping("/api/Reservation")
@CrossOrigin
public class ReservationController {
    @Autowired
    private ReservationService clientService;
    @GetMapping("/all")
    public List<Reservation> getAll(){
        return clientService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Reservation> getCostume(@PathVariable int id){
        return clientService.getReservation(id);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation costume){
        return clientService.save(costume);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation updateCostume(@RequestBody Reservation costume){
        return clientService.update(costume);
    }
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public boolean deteleCostume(@PathVariable int id){
        return clientService.deleteReservation(id);
    }
    @DeleteMapping("/delete/all")
    @ResponseStatus(HttpStatus.CREATED)
    public boolean deteleAllCostumes(){
        return clientService.deleteAll();
    }
}
