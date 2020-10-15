/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.pejic.zavrsnirad.controller;

import hr.pejic.zavrsnirad.model.Alergen;
import hr.pejic.zavrsnirad.model.Osoba;
import hr.pejic.zavrsnirad.utility.Iznimka;
import hr.pejic.zavrsnirad.utility.Oib;
import java.util.List;

/**
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
        checkOib();

    }

    @Override
    protected void kontrolaAzuriraj() throws Iznimka {
        checkOibIzmjena();
        
    }

    @Override
    protected void kontrolaObrisi() throws Iznimka {

    }
    
    public void azurirajAlergenOsobe() throws Iznimka{
        
        session.beginTransaction();
        session.save(entitet);
        session.getTransaction().commit();
        
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

    private void checkOib() throws Iznimka {

        if (entitet.getOib() == null) {

        } else if (!Oib.provjeraOib(entitet.getOib())) {
            throw new Iznimka("Neispravan unos OIB-a");
        }
        checkOibIzmjena();
        
        
    }
    
    private void checkOibIzmjena() throws Iznimka{
        
        List<String> osobeOib = session.createQuery("select o.oib from Osoba o").list();
        
        for(String o : osobeOib){
            if(entitet.getOib().equals(o)){
                throw new Iznimka("Osoba pod tim OIB-om već postoji");
            }
        }
    }

    private void checkAlergen() throws Iznimka {

//        List<Alergen> lista = session.createQuery("from Alergen a where a.naziv=naziv").list();
//        
//        for (Alergen a : lista) {
//
//            if (entitet.getAlergeni().contains(a)) {
//                throw new Iznimka("Alergen je već dodijeljen osobi");
//            }
//        }

//       if(lista.size()>0){
//           throw  new EdunovaException("Oib je dodjeljen " + lista.get(0).getImePrezime() + ", odaberite drugi OIB");
//       }
    }

}
