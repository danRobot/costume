/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo3.costume.service;


import com.ciclo3.costume.repository.ReservationRepository;
import com.ciclo3.costume.model.Reservation;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author danm
 */

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository repositorio;
    public List<Reservation> getAll(){
        return (List<Reservation>)repositorio.findAll();
    }
    public Optional<Reservation> getReservation(int id){
        return repositorio.findById(id);
    }
     
    public Reservation save(Reservation reservation) {
        if (reservation.getIdReservation()== null) {
            return repositorio.save(reservation);
        } else {
            Optional<Reservation> unDisfraz = getReservation(reservation.getIdReservation());

            if (unDisfraz.isEmpty()) {
                return repositorio.save(reservation);
            } else {
                return reservation;
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
    
    public boolean deleteReservation(int id) {
        Optional<Reservation> unReservatione = getReservation(id);

        if (unReservatione.isEmpty()) {
            return false;
        } else {
            repositorio.delete(unReservatione.get());
            return true;
        }
    }
    
    public Reservation update(Reservation reservation) {
        if (reservation.getIdReservation()!= null) {
            Optional<Reservation> e = getReservation(reservation.getIdReservation());
            if (!e.isEmpty()) {
                if (reservation.getStartDate()!= null) {
                    e.get().setStartDate(   reservation.getStartDate());
                }
                if (reservation.getDevolutionDate()!= null) {
                    e.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if (reservation.getStatus()!= null) {
                    e.get().setStatus(reservation.getStatus());
                }
                /*if (costume.getCategory() != null) {
                    e.get().setCategory(costume.getCategory());
                }*/
                repositorio.save(e.get());
                return e.get();
            } else {
                return reservation;
            }
        } else {
            return reservation;
        }
    }
}
