/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.pejic.zavrsnirad.controller;

import hr.pejic.zavrsnirad.model.Sastojak;
import hr.pejic.zavrsnirad.utility.Iznimka;
import java.util.List;

/**
 *
 * @author Pejić
 */
public class ObradaSastojak extends ObradaNaziv<Sastojak> {

    @Override
    public List<Sastojak> ispis() {
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
