/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo3.costume.service;

import com.ciclo3.costume.repository.ScoreRepository;
import com.ciclo3.costume.model.Score;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author danm
 */
@Service
public class ScoreService {
    
    @Autowired
    private ScoreRepository repositorio;
    public List<Score> getAll(){
        return (List<Score>)repositorio.findAll();
    }
    public Optional<Score> getScore(int id){
        return repositorio.findById(id);
    }
     
    public Score save(Score client) {
        if (client.getIdScore()== null) {
            return repositorio.save(client);
        } else {
            Optional<Score> unDisfraz = getScore(client.getIdScore());

            if (unDisfraz.isEmpty()) {
                return repositorio.save(client);
            } else {
                return client;
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
    
    public boolean deleteScore(int id) {
        Optional<Score> unScoree = getScore(id);

        if (unScoree.isEmpty()) {
            return false;
        } else {
            repositorio.delete(unScoree.get());
            return true;
        }
    }
    
    public Score update(Score client) {
        if (client.getIdScore()!= null) {
            Optional<Score> e = getScore(client.getIdScore());
            if (!e.isEmpty()) {
                if (client.getMessageText()!= null) {
                    e.get().setMessageText(client.getMessageText());
                }
                if (client.getStars()!= null) {
                    e.get().setStars(client.getStars());
                }
                repositorio.save(e.get());
                return e.get();
            } else {
                return client;
            }
        } else {
            return client;
        }
    }
}
