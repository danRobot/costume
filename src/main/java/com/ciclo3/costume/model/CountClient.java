/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo3.costume.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.ciclo3.costume.model.Client;

/**
 *
 * @author danm
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountClient {
    public CountClient(long total,Client client){
        this.total=total;
        this.client=client;
    }
    private Long total;
    private Client client;

    public Long getTotal() {
        return this.total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Client getClient() {
        return this.client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
