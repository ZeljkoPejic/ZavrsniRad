/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.pejic.zavrsnirad.controller;

import hr.pejic.zavrsnirad.model.Alergen;
import hr.pejic.zavrsnirad.model.Osoba;
import hr.pejic.zavrsnirad.model.Sastojak;
import hr.pejic.zavrsnirad.utility.Iznimka;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author Pejić
 */
public class ObradaAlergen extends ObradaNaziv<Alergen> {

    @Override
    public List<Alergen> ispis() {
        return session.createQuery("from Alergen").list();
    }

    public List<Alergen> ispis(String trazi) {
        return session.createQuery("from Alergen a where a.naziv like :trazi").setParameter("trazi", "%" + trazi + "%").list();
    }

    @Override
    protected void kontrolaKreiraj() throws Iznimka {
        checkNaziv();
        checkNazivKreiraj();
        checkOpis();   
    }

    @Override
    protected void kontrolaAzuriraj() throws Iznimka {
        checkNaziv();
        checkNazivIzmjena();
    }

    @Override
    protected void kontrolaObrisi() throws Iznimka {
        checkBrisanje();
    }

    private void checkOpis() {
        if (entitet.getOpis() == null || entitet.getOpis().trim().isEmpty()) {
            entitet.setOpis("Nema opisa");
        }
    }

    private void checkBrisanje() throws Iznimka {
        // Treba to bolje odraditi
        List<Osoba> osobe = entitet.getOsobe();
        if (osobe != null) {
            for (int i = 0; i < osobe.size(); i++) {
                List<Alergen> alergeni = osobe.get(i).getAlergeniOsobe();
                for (Alergen a : alergeni) {
                    if (entitet.getId().equals(a.getId())) {
                        throw new Iznimka("Nemoguće obrisati, neke osobe imaju alergen " + entitet.getNaziv());
                    }
                }
            }
        }
        // Treba to bolje odraditi
        List<Sastojak> sastojci = entitet.getSastojci();
        if (sastojci != null) {
            for (int i = 0; i < sastojci.size(); i++) {
                List<Alergen> alergeni = sastojci.get(i).getAlergeniSastojak();
                for (Alergen a : alergeni) {
                    if (entitet.getId().equals(a.getId())) {
                        throw new Iznimka("Nemoguće obrisati, neki sastojci imaju alergen " + entitet.getNaziv());
                    }
                }
            }
        }
    }
    
    @Override
    protected void checkNazivIzmjena() throws Iznimka{
         Query query =session.createQuery("select count(k) from "+entitet.getClass().getSimpleName()+" k where k.naziv=:naziv and sifra!=:sifra")
                 .setParameter("naziv", entitet.getNaziv())
                 .setParameter("sifra", entitet.getId());
         Long count = (Long) query.uniqueResult();
         if(count!=0){
             throw new Iznimka(entitet.getClass().getSimpleName()+" već postoji");
         }
    }

}
