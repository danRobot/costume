/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo3.costume.service;


import com.ciclo3.costume.repository.CategoryRepository;
import com.ciclo3.costume.model.Category;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author danm
 */
@Service
public class CategoryService {
    @Autowired
    private CategoryRepository repositorio;
    public List<Category> getAll(){
        return (List<Category>)repositorio.findAll();
    }
    public Optional<Category> getCategory(int id){
        return repositorio.findById(id);
    }
     
    public Category save(Category client) {
        if (client.getIdCategory()== null) {
            return repositorio.save(client);
        } else {
            Optional<Category> unDisfraz = getCategory(client.getIdCategory());

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
    
    public boolean deleteCategory(int id) {
        Optional<Category> unCategorye = getCategory(id);

        if (unCategorye.isEmpty()) {
            return false;
        } else {
            repositorio.delete(unCategorye.get());
            return true;
        }
    }
    
    public Category update(Category client) {
        if (client.getIdCategory()!= null) {
            Optional<Category> e = getCategory(client.getIdCategory());
            if (!e.isEmpty()) {
                if (client.getName() != null) {
                    e.get().setName(client.getName());
                }
                if (client.getDescription()!= null) {
                    e.get().setDescription(client.getDescription());
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
