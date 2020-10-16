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
        return session.createQuery("from Sastojak").list();
    }
    
    @Override
    protected void kontrolaKreiraj() throws Iznimka {
        super.checkNaziv();
        checkNazivKreiraj();
    }

    @Override
    protected void kontrolaAzuriraj() throws Iznimka {
       super.checkNaziv();
    }

    @Override
    protected void kontrolaObrisi() throws Iznimka {
        
    }
    
    private void checkNazivKreiraj()throws Iznimka{
        
        List<String> listaNaziva = session.createQuery("from Sastojak s where s.naziv=:naziv").setParameter("naziv", entitet.getNaziv()).list();
        if(!(listaNaziva.isEmpty())){
            throw new Iznimka("Sastojak već postoji");
        }
        
    }

    
           
}
