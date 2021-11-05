/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo3.costume.controller;

import com.ciclo3.costume.service.MessageService;
import com.ciclo3.costume.model.Message;
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
@RequestMapping("/api/Message")
@CrossOrigin
public class MessageController {
    @Autowired
    private MessageService clientService;
    @GetMapping("/all")
    public List<Message> getAll(){
        return clientService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Message> getCostume(@PathVariable int id){
        return clientService.getMessage(id);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message save(@RequestBody Message costume){
        return clientService.save(costume);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Message updateCostume(@RequestBody Message costume){
        return clientService.update(costume);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deteleCostume(@PathVariable int id){
        return clientService.deleteMessage(id);
    }
    @DeleteMapping("/all")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deteleAllCostumes(){
        return clientService.deleteAll();
    }
}
