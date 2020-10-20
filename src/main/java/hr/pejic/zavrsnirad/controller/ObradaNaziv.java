/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.pejic.zavrsnirad.controller;

import hr.pejic.zavrsnirad.model.AttributeNaziv;
import hr.pejic.zavrsnirad.utility.Iznimka;
import org.hibernate.query.Query;

/**
 *
 * @author Pejić
 */
public abstract class ObradaNaziv<T extends AttributeNaziv> extends Obrada<T> {

    @Override
    protected void kontrolaKreiraj() throws Iznimka{
        //checkNaziv();
    }

    @Override
    protected void kontrolaObrisi() throws Iznimka{
        //checkNaziv();
    }

    @Override
    protected void kontrolaAzuriraj() throws Iznimka{
        
    }
        
    
    protected void checkNaziv() throws Iznimka{
                     
        if(entitet.getNaziv()==null || entitet.getNaziv().trim().isEmpty()){
            throw new Iznimka("Naziv je obavezan");
        }                       
    }
    
    protected void checkNazivKreiraj() throws Iznimka {
        Query query =session.createQuery("select count(k) from "+entitet.getClass().getSimpleName()+" k where k.naziv=:naziv")
                .setParameter("naziv", entitet.getNaziv());
        Long count = (Long)query.uniqueResult();
        if(count!=0){
            throw new Iznimka("<html><p>"+entitet.getClass().getSimpleName()+" pod tim nazivom već postoji</p></html>");
        }
    }
     protected void checkNazivIzmjena() throws Iznimka {
        
         Query query =session.createQuery("select count(k) from "+entitet.getClass().getSimpleName()+" k where k.naziv=:naziv and sifra=:sifra")
                 .setParameter("naziv", entitet.getNaziv())
                 .setParameter("sifra", entitet.getId());
         Long count = (Long) query.uniqueResult();
         if(count!=0){
             throw new Iznimka(entitet.getClass().getSimpleName()+" već postoji");
         }
    }
    
}
