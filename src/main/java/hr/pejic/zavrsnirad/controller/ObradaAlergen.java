/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.pejic.zavrsnirad.controller;

import hr.pejic.zavrsnirad.model.Alergen;
import hr.pejic.zavrsnirad.utility.Iznimka;

/**
 *
 * @author Pejić
 */
public class ObradaAlergen extends Obrada<Alergen> {

    @Override
    protected void kontrolaKreiraj() throws Iznimka {
       checkNaziv();
       checkOpis();   // Je li mi treba? Moze biti null
    }

    @Override
    protected void kontrolaAzuriraj() throws Iznimka {
    }

    @Override
    protected void kontrolaObrisi() throws Iznimka {
       
    }
    
    // Napraviti kao jednu metodu koja se poziva na više mjesta
    private void checkNaziv() throws Iznimka{
        
        if(entitet.getNaziv()==null || entitet.getNaziv().isEmpty()){
            throw new Iznimka("Naziv je obavezan");
        }
               
    }

    private void checkOpis() {
       
    }
    
    
    
}
