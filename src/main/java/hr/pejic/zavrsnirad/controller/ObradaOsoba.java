/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.pejic.zavrsnirad.controller;

import hr.pejic.zavrsnirad.model.Alergen;
import hr.pejic.zavrsnirad.model.Osoba;
import hr.pejic.zavrsnirad.utility.Iznimka;
import hr.pejic.zavrsnirad.utility.PomocneMetode;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 *
 * @author Pejić
 */
public class ObradaOsoba extends Obrada<Osoba> {

    @Override
    public List<Osoba> ispis() {
        return session.createQuery("from Osoba").list();
    }

    public List<Osoba> ispis(String trazi) {
        return session.createQuery("from Osoba o where concat(o.ime, ' ', o.prezime, ' ', o.oib) "
                + " like :trazi ").setParameter("trazi", "%" + trazi + "%").list();
    }

    public ObradaOsoba(Osoba osoba) {
        super(osoba);
    }

    public ObradaOsoba() {
        super();
    }

    @Override
    protected void kontrolaKreiraj() throws Iznimka {

        checkIme();
        checkPrezime();
        checkOibKreiraj();

    }

    @Override
    protected void kontrolaAzuriraj() throws Iznimka {
        checkIme();
        checkPrezime();
        checkOibIzmjena();

    }

    @Override
    protected void kontrolaObrisi() throws Iznimka {

    }

    public void azurirajAlergenOsobe(List<Alergen> lista) throws Iznimka {

        List<Alergen> pokupljeni = entitet.getAlergeniOsobe();
        boolean promjena = false;
        nastavi:
        for (Alergen a : lista) {
            for (Alergen p : pokupljeni) {
                if (a.getId().equals(p.getId())) {
                    continue nastavi;
                }
            }
            entitet.getAlergeniOsobe().add(a);
            promjena = true;

        }
        if (promjena) {
            spremiEntitet();
        } else {
            throw new Iznimka("Odabrani alergeni su već uneseni");
        }

    }

    public void obrisiAlergenOsobe() {

        spremiEntitet();

    }

    private void checkIme() throws Iznimka {

        if (entitet.getIme().isEmpty() || entitet.getIme() == null) {
            throw new Iznimka("Ime je obavezno, ne može biti prazno");
        }
        if (!entitet.getIme().matches(".*[a-zA-Z]+.*")) {
            throw new Iznimka("Ime mora sadržavati bar jedno slovo");
        }
    }

    private void checkPrezime() throws Iznimka {

        if (entitet.getPrezime().isEmpty() || entitet.getIme() == null) {
            throw new Iznimka("Prezime je obavezno, ne može biti prazno");
        }
        if (!entitet.getPrezime().matches(".*[a-zA-Z]+.*")) {
            throw new Iznimka("Prezime mora sadržavati bar jedno slovo");
        }
    }

    private void checkOibKreiraj() throws Iznimka {

        checkOib();

        Query query = session.createQuery("select count(o) from Osoba o where o.oib=:oib")
                .setParameter("oib", entitet.getOib());                
        Long count = (Long) query.uniqueResult();
        if (count != 0) {
            throw new Iznimka("Osoba pod tim OIB-om već postoji");
        }

    }

    private void checkOib() throws Iznimka {
        if (entitet.getOib() == null || entitet.getOib().trim().isEmpty()) {
            throw new Iznimka("OIB je obavezan");
        }
        if (!PomocneMetode.provjeraOib(entitet.getOib())) {
            throw new Iznimka("Neispravan unos OIB-a");
        }
    }

    private void checkOibIzmjena() throws Iznimka {

        checkOib();

        Query query = session.createQuery("select count(o) from Osoba o where o.oib=:oib and sifra!=:sifra")
                .setParameter("oib", entitet.getOib())
                .setParameter("sifra", entitet.getId());
        Long count = (Long) query.uniqueResult();
        if (count != 0) {
            throw new Iznimka("Osoba pod tim OIB-om već postoji");
        }

    }

}
