/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.pejic.zavrsnirad.controller;

import hr.pejic.zavrsnirad.model.Alergen;
import hr.pejic.zavrsnirad.utility.Iznimka;
import java.util.List;

/**
 *
 * @author Pejić
 */
public class ObradaAlergen extends ObradaNaziv<Alergen> {

    @Override
    public List<Alergen> ispis() {
        return session.createQuery("from Alergen").list();
    }
    
    public List<Alergen> ispis(String trazi){
        return session.createQuery("from Alergen a where a.naziv=:trazi").setParameter("trazi", "%"+trazi+"%").list();
        
    }
    
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
      

    private void checkOpis() {
       if(entitet.getOpis()==null || entitet.getOpis().trim().isEmpty()){
           entitet.setOpis("Nema opisa");
       }
    }

    
    
    
    
}
