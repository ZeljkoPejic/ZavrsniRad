/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.pejic.zavrsnirad.controller;

import hr.pejic.zavrsnirad.model.Recept;
import hr.pejic.zavrsnirad.utility.Iznimka;
import java.util.List;

/**
 *
 * @author Pejić
 */
public class ObradaRecept extends ObradaNaziv<Recept>{

    @Override
    public List<Recept> ispis() {
        return null;
    }
    
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

    
    
    
}
