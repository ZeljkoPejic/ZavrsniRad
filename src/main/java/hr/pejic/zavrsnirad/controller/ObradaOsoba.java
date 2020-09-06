/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.pejic.zavrsnirad.controller;

import hr.pejic.zavrsnirad.model.Osoba;
import hr.pejic.zavrsnirad.utility.Iznimka;
import hr.pejic.zavrsnirad.utility.Oib;

/**
 *
 * @author Pejić
 */
public class ObradaOsoba extends Obrada<Osoba> {

    public ObradaOsoba(Osoba osoba){
        super(osoba);
    }
    
    public ObradaOsoba(){
        super();
    }
    
    @Override
    protected void kontrolaKreiraj() throws Iznimka {
        
        checkIme();
        checkPrezime();
        checkOib();
              
    }

    @Override
    protected void kontrolaAzuriraj() throws Iznimka {
       
    }

    @Override
    protected void kontrolaObrisi() throws Iznimka {
        
        
       
    }
    
    private void checkIme() throws Iznimka{
                       
        if(entitet.getIme().isEmpty() || entitet.getIme()==null){
            throw new Iznimka("Ime je obavezno, ne može biti prazno");
        }
        if(!entitet.getIme().matches(".*[a-zA-Z]+.*")){
            throw new Iznimka("Ime mora sadržavati bar jedno slovo");
        }
    }
    
    private void checkPrezime() throws Iznimka{
        
        if(entitet.getPrezime().isEmpty() || entitet.getIme()==null){
            throw new Iznimka("Prezime je obavezno, ne može biti prazno");
        }
        if(!entitet.getPrezime().matches(".*[a-zA-Z]+.*")){
            throw new Iznimka("Prezime mora sadržavati bar jedno slovo");
        }
    }
       
    private void checkOib() throws Iznimka{
        
        if(entitet.getOib()==null){
            
        }else if(!Oib.provjeraOib(entitet.getOib())){
            throw new Iznimka("Neispravan unos OIB-a");
        }
                        
    }
    
        
        
    
    
    
    
}
