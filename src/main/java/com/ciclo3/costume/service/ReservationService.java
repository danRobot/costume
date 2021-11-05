    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo3.costume.service;


import com.ciclo3.costume.model.Client;
import com.ciclo3.costume.model.CountClient;
import com.ciclo3.costume.model.StatusAmount;
import com.ciclo3.costume.repository.ReservationRepository;
import com.ciclo3.costume.model.Reservation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
    
    public List<Reservation> getReservationsPeriod(String dateA, String dateB){
        SimpleDateFormat parser=new SimpleDateFormat("yyyy-MM-dd");
        Date a= new Date();
        Date b=new Date();
        try {
            a = parser.parse(dateA);
            b = parser.parse(dateB);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(a.before(b)){
            return repositorio.findAllByStartDateAfterAndStartDateBefore(a,b);
        }else{
            return new ArrayList<>();
        }

    }
    
    public StatusAmount getReservationsStatusReport(){
        List<Reservation>completed=repositorio.findAllByStatus("completed");
        List<Reservation>cancelled=repositorio.findAllByStatus("cancelled");
        return new StatusAmount(completed.size(),cancelled.size());

    }
    public  List<CountClient> getTopClients(){
        List<CountClient>res=new ArrayList<>();
        List<Object[]>report=repositorio.countTotalReservationsByClient();
        for(int i=0;i<report.size();i++){
            res.add(new CountClient((Long)report.get(i)[1],(Client) report.get(i)[0]));
        }
        return res;
    }
}
