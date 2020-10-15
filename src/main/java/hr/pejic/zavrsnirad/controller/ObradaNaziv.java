/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.pejic.zavrsnirad.controller;

import hr.pejic.zavrsnirad.model.AttributeNaziv;
import hr.pejic.zavrsnirad.utility.Iznimka;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pejić
 */
public abstract class ObradaNaziv<T extends AttributeNaziv> extends Obrada<T> {

    @Override
    protected void kontrolaKreiraj() throws Iznimka{
        checkNaziv();
    }

    @Override
    protected void kontrolaObrisi() throws Iznimka{
        
    }

    @Override
    protected void kontrolaAzuriraj() throws Iznimka{
        
    }
        
    
    protected void checkNaziv() throws Iznimka{
        
        //?????
        //entitet.getNaziv();
        
        
               
        if(entitet.getNaziv()==null || entitet.getNaziv().isEmpty()){
            throw new Iznimka("Naziv je obavezan");
        }
        
               
    }
    
}
