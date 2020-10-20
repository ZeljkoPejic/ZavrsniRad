/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.pejic.zavrsnirad.controller;

import hr.pejic.zavrsnirad.model.Alergen;
import hr.pejic.zavrsnirad.model.Osoba;
import hr.pejic.zavrsnirad.model.Recept;
import hr.pejic.zavrsnirad.model.Sastojak;
import hr.pejic.zavrsnirad.utility.Iznimka;
import java.util.List;
import org.hibernate.query.Query;


/**
 *
 * @author Pejić
 */
public class ObradaSastojak extends ObradaNaziv<Sastojak> {

    @Override
    public List<Sastojak> ispis() {
        return session.createQuery("from Sastojak").list();
    }

    public List<Sastojak> ispis(String trazi) {
        return session.createQuery("from Sastojak s where s.naziv like :trazi").setParameter("trazi", "%" + trazi + "%").list();
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
        checkBrisanje();
    }

    public void azurirajAlergenSastojka(List<Alergen> lista) throws Iznimka {

        List<Alergen> pokupljeni = entitet.getAlergeniSastojak();
        boolean promjena=false;
        nastavi:
        for (Alergen list : lista) {
            for (Alergen pokup : pokupljeni) {
                if (list.getId().equals(pokup.getId())) {
                    continue nastavi;
                }
            }
            entitet.getAlergeniSastojak().add(list);
            promjena=true;

        }
        if(promjena){
        session.beginTransaction();
        session.save(entitet);
        session.getTransaction().commit();
       
        }else{
            throw new Iznimka("Odabrani alergeni su već uneseni");
        }
    }

    public void obrisiAlergenSastojka() {
        session.beginTransaction();
        session.save(entitet);
        session.getTransaction().commit();       
    }
    
    private void checkBrisanje() throws Iznimka{
        // Treba to bolje odraditi
        List<Recept> recepti = entitet.getReceptiSastojka();
        if (recepti != null) {
            for (int i = 0; i < recepti.size(); i++) {
                List<Sastojak> sastojci = recepti.get(i).getSastojciRecepta();
                for (Sastojak s : sastojci) {
                    if (entitet.getId().equals(s.getId())) {
                        throw new Iznimka("<html><p>Nemoguće obrisati, neki recepti imaju sastojak " + entitet.getNaziv()+"</p></html>");
                    }
                }
            }
        }
    }

}
