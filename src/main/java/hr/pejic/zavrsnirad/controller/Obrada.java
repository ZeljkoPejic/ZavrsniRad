/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.pejic.zavrsnirad.controller;

import hr.pejic.zavrsnirad.utility.HibernateUtility;
import hr.pejic.zavrsnirad.utility.Iznimka;
import org.hibernate.Session;

/**
 *
 * @author Pejić
 */
public abstract class Obrada<T>{
    
    private T entitet;
    private Session session;
    
    protected abstract void kontrolaKreiraj() throws Iznimka;
    protected abstract void kontrolaAzuriraj() throws Iznimka;
    protected abstract void kontrolaObrisi() throws Iznimka;
    
    public Obrada(T entitet){
        this.session = HibernateUtility.getSessionFactory().openSession();
        this.entitet = entitet;
    }

    public T getEntitet() {
        return entitet;
    }

    public void setEntitet(T entitet) {
        this.entitet = entitet;
    }
    
    
    
    
}
