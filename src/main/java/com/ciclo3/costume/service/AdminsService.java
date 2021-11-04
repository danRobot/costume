/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo3.costume.service;


import com.ciclo3.costume.repository.AdminsRepository;
import com.ciclo3.costume.model.Admins;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author danm
 */

@Service
public class AdminsService {
    @Autowired
    private AdminsRepository repositorio;
    public List<Admins> getAll(){
        return (List<Admins>)repositorio.findAll();
    }
    public Optional<Admins> getAdmins(int id){
        return repositorio.findById(id);
    }
     
    public Admins save(Admins client) {
        if (client.getIdAdmin()== null) {
            return repositorio.save(client);
        } else {
            Optional<Admins> unDisfraz = getAdmins(client.getIdAdmin());

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
    
    public boolean deleteAdmins(int id) {
        Optional<Admins> unAdminse = getAdmins(id);

        if (unAdminse.isEmpty()) {
            return false;
        } else {
            repositorio.delete(unAdminse.get());
            return true;
        }
    }
    
    public Admins update(Admins client) {
        if (client.getIdAdmin()!= null) {
            Optional<Admins> e = getAdmins(client.getIdAdmin());
            if (!e.isEmpty()) {
                if (client.getName() != null) {
                    e.get().setName(client.getName());
                }
                if (client.getEmail()!= null) {
                    e.get().setEmail(client.getEmail());
                }
                if (client.getPassword()!= null) {
                    e.get().setPassword(client.getPassword());
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
