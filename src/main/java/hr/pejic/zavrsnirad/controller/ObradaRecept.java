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

    protected void checkNaziv()throws Iznimka{
        super.checkNaziv();
        List<Recept> lista = session.createQuery("from Recept t where t.naziv=:naziv").setParameter("naziv", entitet.getNaziv()).list();
        if(lista.size() > 0){
            throw new Iznimka("Recept pod tim nazivom vec postoji");
        }
    }
    
    
}
