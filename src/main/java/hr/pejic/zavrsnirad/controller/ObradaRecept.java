/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.pejic.zavrsnirad.controller;

import hr.pejic.zavrsnirad.model.Recept;
import hr.pejic.zavrsnirad.utility.Iznimka;

/**
 *
 * @author Pejić
 */
public class ObradaRecept extends Obrada<Recept>{

    @Override
    protected void kontrolaKreiraj() throws Iznimka {
      checkNaziv();
    }

    @Override
    protected void kontrolaAzuriraj() throws Iznimka {
        
    }

    @Override
    protected void kontrolaObrisi() throws Iznimka {
       
    }
    
    private void checkNaziv() throws Iznimka{
        
        if(entitet.getNaziv()==null || entitet.getNaziv().isEmpty()){
            throw new Iznimka("Naziv je obavezan");
        }
               
    }
    
    
}
