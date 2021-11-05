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
        if (client.getId()== null) {
            return repositorio.save(client);
        } else {
            Optional<Category> unDisfraz = getCategory(client.getId());

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
    
    public Category update(Category category) {
        if (category.getId()!= null) {
            Optional<Category> e = getCategory(category.getId());
            if (!e.isEmpty()) {
                if (category.getName() != null) {
                    e.get().setName(category.getName());
                }
                if (category.getDescription()!= null) {
                    e.get().setDescription(category.getDescription());
                }
                repositorio.save(e.get());
                return e.get();
            } else {
                return category;
            }
        } else {
            return category;
        }
    }
}
