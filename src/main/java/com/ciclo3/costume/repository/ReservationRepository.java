/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo3.costume.repository;

import com.ciclo3.costume.model.Reservation;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author danm
 */

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer>{
    
}