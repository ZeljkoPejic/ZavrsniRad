/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.pejic.zavrsnirad.controller;

import hr.pejic.zavrsnirad.model.Recept;
import hr.pejic.zavrsnirad.model.Sastojak;
import hr.pejic.zavrsnirad.utility.Iznimka;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author Pejić
 */
public class ObradaRecept extends ObradaNaziv<Recept> {

    @Override
    public List<Recept> ispis() {
        return session.createQuery("from Recept").list();
    }

    public List<Recept> ispis(String trazi) {
        return session.createQuery("from Recept r where r.naziv=:naziv").setParameter("naziv", trazi).list();
    }

    @Override
    protected void kontrolaKreiraj() throws Iznimka {
        checkNaziv();
        checkNazivKreiraj();
    }

    @Override
    protected void kontrolaAzuriraj() throws Iznimka {
        checkNaziv();
        checkNazivIzmjena();
    }

    @Override
    protected void kontrolaObrisi() throws Iznimka {

    }

    public void azurirajSastojakRecepta(List<Sastojak> sastojci) throws Iznimka {

        List<Sastojak> pokupljeni = entitet.getSastojciRecepta();
        boolean promjena = false;
        nastavi:
        for (Sastojak list : sastojci) {
            for (Sastojak pokup : pokupljeni) {
                if (list.getId().equals(pokup.getId())) {
                    continue nastavi;
                }
            }
            entitet.getSastojciRecepta().add(list);
            promjena = true;

        }
        if (promjena) {
            session.beginTransaction();
            session.save(entitet);
            session.getTransaction().commit();

        } else {
            throw new Iznimka("Odabrani sastojci su već dodijeljeni");
        }
    }
    public void obrisiSastojakRecepta(){
        session.beginTransaction();
        session.save(entitet);
        session.getTransaction().commit(); 
    }

}
