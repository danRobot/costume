/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo3.costume.service;


import com.ciclo3.costume.repository.MessageRepository;
import com.ciclo3.costume.model.Message;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author danm
 */

@Service
public class MessageService {
    @Autowired
    private MessageRepository repositorio;
    public List<Message> getAll(){
        return (List<Message>)repositorio.findAll();
    }
    public Optional<Message> getMessage(int id){
        return repositorio.findById(id);
    }
     
    public Message save(Message message) {
        if (message.getIdMessage()== null) {
            return repositorio.save(message);
        } else {
            Optional<Message> unDisfraz = getMessage(message.getIdMessage());

            if (unDisfraz.isEmpty()) {
                return repositorio.save(message);
            } else {
                return message;
            }
        }
    }
    public boolean deleteAll(){
        repositorio.deleteAll();
        if (repositorio.count()==0) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean deleteMessage(int id) {
        Optional<Message> unMessagee = getMessage(id);

        if (unMessagee.isEmpty()) {
            return false;
        } else {
            repositorio.delete(unMessagee.get());
            return true;
        }
    }
    
    public Message update(Message message) {
        if (message.getIdMessage()!= null) {
            Optional<Message> e = getMessage(message.getIdMessage());
            if (!e.isEmpty()) {
                if (message.getMessageText()!= null) {
                    e.get().setMessageText(message.getMessageText());
                }
                repositorio.save(e.get());
                return e.get();
            } else {
                return message;
            }
        } else {
            return message;
        }
    }
}
