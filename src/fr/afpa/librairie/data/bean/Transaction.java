/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.afpa.librairie.data.bean;

import java.sql.Date;

/**
 *
 * @author cdi309
 */
public class Transaction {
    
    private Long id;
    private Date dateTransaction;

    public Transaction() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDateTransaction() {
        return dateTransaction;
    }

    public void setDateTransaction(Date dateTransaction) {
        this.dateTransaction = dateTransaction;
    }

    @Override
    public String toString() {
        return "Transaction{" + "id=" + id + ", dateTransaction=" + dateTransaction + '}';
    }
    
    
}
