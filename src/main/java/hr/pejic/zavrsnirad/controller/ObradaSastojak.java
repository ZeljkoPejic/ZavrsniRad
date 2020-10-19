/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.pejic.zavrsnirad.controller;

import hr.pejic.zavrsnirad.model.Alergen;
import hr.pejic.zavrsnirad.model.Sastojak;
import hr.pejic.zavrsnirad.utility.Iznimka;
import java.util.Iterator;
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

    public List<Sastojak> ispis(String trazi) {
        return session.createQuery("from Sastojak s where s.naziv like :trazi").setParameter("trazi", "%" + trazi + "%").list();
    }

    @Override
    protected void kontrolaKreiraj() throws Iznimka {
        super.checkNaziv();
        checkNazivKreiraj();
    }

    @Override
    protected void kontrolaAzuriraj() throws Iznimka {
        super.checkNaziv();
        checkNazivIzmjena();
    }

    @Override
    protected void kontrolaObrisi() throws Iznimka {

    }

    private void checkNazivKreiraj() throws Iznimka {

        List<String> listaNaziva = session.createQuery("from Sastojak s where s.naziv=:naziv").setParameter("naziv", entitet.getNaziv()).list();
        if (!(listaNaziva.isEmpty())) {
            throw new Iznimka("Sastojak već postoji");
        }
//        try{
//            Sastojak provjeraNaziv = (Sastojak) session.createQuery("from Sastojak s where s.naziv=:naziv").setParameter("naziv", entitet.getNaziv()).getSingleResult();
//            if(provjeraNaziv!=null){
//                throw new Iznimka("Sastojak već postoji");
//            }
//        }catch(Exception e){
//            
//        }

    }

    private void checkNazivIzmjena() throws Iznimka {
        List<Sastojak> lista = session.createQuery("from Sastojak s where s.naziv=:naziv and sifra=:sifra")
                .setParameter("naziv", entitet.getNaziv()).setParameter("sifra", entitet.getId()).list();
        if (!(lista.isEmpty())) {
            throw new Iznimka("Sastojak već postoji");
        }
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

}
