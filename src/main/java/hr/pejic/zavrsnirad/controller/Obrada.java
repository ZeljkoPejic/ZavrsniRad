/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.pejic.zavrsnirad.controller;

import hr.pejic.zavrsnirad.utility.HibernateUtility;
import hr.pejic.zavrsnirad.utility.Iznimka;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Pejić
 */
public abstract class Obrada<T>{
    
    protected T entitet;
    protected Session session;
    
    public abstract List<T> ispis();
    protected abstract void kontrolaKreiraj() throws Iznimka;
    protected abstract void kontrolaAzuriraj() throws Iznimka;
    protected abstract void kontrolaObrisi() throws Iznimka;
    
    public Obrada(T entitet){
        this();
        this.entitet = entitet;
    }

    public Obrada() {
        this.session = HibernateUtility.getSessionFactory().openSession();
    }
    
    public T getEntitet() {
        return entitet;
    }

    public void setEntitet(T entitet) {
        this.entitet = entitet;
    }
    
    public T kreiraj() throws Iznimka{
        
        kontrolaKreiraj();
        spremiEntitet();
        
        return entitet;
                
    }
    
    public T azuriraj() throws Iznimka{
        
        kontrolaAzuriraj();
        spremiEntitet();
        
        return entitet;
    }
            
    public T obrisi() throws Iznimka{
        
        kontrolaObrisi();
        obrisiEntitet();
        
        return entitet;
    }
    

    protected void spremiEntitet() {
        session.beginTransaction();
        session.save(entitet);
        session.getTransaction().commit();
    }
    
    protected void obrisiEntitet(){
        session.beginTransaction();
        session.delete(entitet);
        session.getTransaction().commit();
    } 
    
}
