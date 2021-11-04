/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo3.costume.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author danm
 */

@Entity
@Table(name = "score")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idScore;
    @Column(nullable = false,length = 250)
    private String messageText;
    private Integer stars;

    /**
     * @return the idScore
     */
    public Integer getIdScore() {
        return idScore;
    }

    /**
     * @param idScore the idScore to set
     */
    public void setIdScore(Integer idScore) {
        this.idScore = idScore;
    }

    /**
     * @return the messageText
     */
    public String getMessageText() {
        return messageText;
    }

    /**
     * @param messageText the messageText to set
     */
    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    /**
     * @return the stars
     */
    public Integer getStars() {
        return stars;
    }

    /**
     * @param stars the stars to set
     */
    public void setStars(Integer stars) {
        this.stars = stars;
    }
}
