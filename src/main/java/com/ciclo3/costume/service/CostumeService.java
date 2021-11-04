/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo3.costume.service;

import com.ciclo3.costume.repository.CostumeRepository;
import com.ciclo3.costume.model.Costume;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
/**
 *
 * @author danm
 */

@Service
public class CostumeService {
    @Autowired
    private CostumeRepository repositorio;
    public List<Costume> getAll(){
        return (List<Costume>)repositorio.findAll();
    }
    public Optional<Costume> getCostume(int id){
        return repositorio.findById(id);
    }
     
    public Costume save(Costume costume) {
        if (costume.getId() == null) {
            return repositorio.save(costume);
        } else {
            Optional<Costume> unDisfraz = getCostume(costume.getId());

            if (unDisfraz.isEmpty()) {
                return repositorio.save(costume);
            } else {
                return costume;
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
    
    public boolean deleteCostume(int id) {
        Optional<Costume> unDisfaz = getCostume(id);

        if (unDisfaz.isEmpty()) {
            return false;
        } else {
            repositorio.delete(unDisfaz.get());
            return true;
        }
    }
    
    public Costume update(Costume costume) {
        if (costume.getId() != null) {
            Optional<Costume> e = getCostume(costume.getId());
            if (!e.isEmpty()) {
                if (costume.getName() != null) {
                    e.get().setName(costume.getName());
                }
                if (costume.getBrand() != null) {
                    e.get().setBrand(costume.getBrand());
                }
                if (costume.getYear() != null) {
                    e.get().setYear(costume.getYear());
                }
                if (costume.getDescription() != null) {
                    e.get().setDescription(costume.getDescription());
                }
                /*if (costume.getCategory() != null) {
                    e.get().setCategory(costume.getCategory());
                }*/
                repositorio.save(e.get());
                return e.get();
            } else {
                return costume;
            }
        } else {
            return costume;
        }
    }
}
