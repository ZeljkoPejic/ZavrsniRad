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
        return session.createQuery("from Alergen a where a.naziv like :trazi").setParameter("trazi", "%"+trazi+"%").list();
        
    }
    
    @Override
    protected void kontrolaKreiraj() throws Iznimka {
       checkNazivKreiraj();
       checkOpis();   // Je li mi treba? Moze biti null
    }

    @Override
    protected void kontrolaAzuriraj() throws Iznimka {
        checkNaziv();
    }

    @Override
    protected void kontrolaObrisi() throws Iznimka {
       checkBrisanje();
    }
      

    private void checkOpis() {
       if(entitet.getOpis()==null || entitet.getOpis().trim().isEmpty()){
           entitet.setOpis("Nema opisa");
       }
    }

    @Override
     protected void checkNaziv()throws Iznimka{
        super.checkNaziv();
        List<Alergen> lista = session.createQuery("from Alergen t where t.naziv=:naziv and sifra!=:sifra")
                .setParameter("naziv", entitet.getNaziv()).setParameter("sifra", entitet.getId()).list();
        if(lista.size() > 0){
            throw new Iznimka("Alergen pod tim nazivom vec postoji");
        }
    }
     
     private void checkNazivKreiraj() throws Iznimka{
         super.checkNaziv();
         List<Alergen> lista = session.createQuery("from Alergen t where t.naziv=:naziv").setParameter("naziv", entitet.getNaziv()).list();
        if(lista.size() > 0){
            throw new Iznimka("Alergen pod tim nazivom vec postoji");
        }
     }
     
     private void checkBrisanje() throws Iznimka{
         
         if(!(entitet.getOsobe().isEmpty())){
             throw new Iznimka("<html>Nemoguće obrisati, neke osobe<br>imaju alergen "+entitet.getNaziv());
         }
         
     }
   
    
    
    
}
