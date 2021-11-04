/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo3.costume.service;


import com.ciclo3.costume.repository.ClientRepository;
import com.ciclo3.costume.model.Client;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author danm
 */

@Service
public class ClientService {
    @Autowired
    private ClientRepository repositorio;
    public List<Client> getAll(){
        return (List<Client>)repositorio.findAll();
    }
    public Optional<Client> getClient(int id){
        return repositorio.findById(id);
    }
     
    public Client save(Client client) {
        if (client.getIdClient()== null) {
            return repositorio.save(client);
        } else {
            Optional<Client> unDisfraz = getClient(client.getIdClient());

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
    
    public boolean deleteClient(int id) {
        Optional<Client> unCliente = getClient(id);

        if (unCliente.isEmpty()) {
            return false;
        } else {
            repositorio.delete(unCliente.get());
            return true;
        }
    }
    
    public Client update(Client client) {
        if (client.getIdClient()!= null) {
            Optional<Client> e = getClient(client.getIdClient());
            if (!e.isEmpty()) {
                if (client.getName() != null) {
                    e.get().setName(client.getName());
                }
                if (client.getEmail()!= null) {
                    e.get().setEmail(client.getEmail());
                }
                if (client.getAge()!= null) {
                    e.get().setAge(client.getAge());
                }
                if (client.getEmail()!= null) {
                    e.get().setEmail(client.getEmail());
                }
                if (client.getPassword()!= null) {
                    e.get().setPassword(client.getPassword());
                }
                /*if (costume.getCategory() != null) {
                    e.get().setCategory(costume.getCategory());
                }*/
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
