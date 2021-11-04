/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo3.costume.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author danm
 */

@Entity
@Table(name = "category")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String name;    
    private String description;
    
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy= "category")
    @JsonIgnoreProperties("category")
    private List<Costume> costumes;

    /**
     * @return the idCategory
     */
    public Integer getIdCategory() {
        return id;
    }

    /**
     * @param idCategory the idCategory to set
     */
    public void setIdCategory(Integer idCategory) {
        this.id = idCategory;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the costumes
     */
    public List<Costume> getCostumes() {
        return costumes;
    }

    /**
     * @param costumes the costumes to set
     */
    public void setCostumes(List<Costume> costumes) {
        this.costumes = costumes;
    }
}
