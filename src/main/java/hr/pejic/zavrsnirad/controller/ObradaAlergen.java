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
        checkNazivKreiraj();
        checkOpis();   // Je li mi treba? Moze biti null
    }

    @Override
    protected void kontrolaAzuriraj() throws Iznimka {
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

    private void checkNazivIzmjena() throws Iznimka {
        super.checkNaziv();
        List<Alergen> lista = session.createQuery("from Alergen a where a.naziv=:naziv and sifra!=:sifra")
                .setParameter("naziv", entitet.getNaziv()).setParameter("sifra", entitet.getId()).list();
        if (!(lista.isEmpty())) {
            throw new Iznimka("Alergen pod tim nazivom vec postoji");
        }
    }

    private void checkNazivKreiraj() throws Iznimka {
        super.checkNaziv();
        List<Alergen> lista = session.createQuery("from Alergen t where t.naziv=:naziv").setParameter("naziv", entitet.getNaziv()).list();
        if (!(lista.isEmpty())) {
            throw new Iznimka("Alergen pod tim nazivom vec postoji");
        }
    }

    private void checkBrisanje() throws Iznimka {
        // Treba to bolje odraditi, krivo mi sto sam nekad glup
        List<Osoba> osobe = entitet.getOsobe();
        if (osobe != null) {
            for (int i = 0; i < osobe.size(); i++) {
                List<Alergen> alergeni = osobe.get(i).getAlergeniOsobe();
                for (Alergen a : alergeni) {
                    if (entitet.getId().equals(a.getId())) {
                        throw new Iznimka("<html>Nemoguće obrisati, neke osobe<br>imaju alergen " + entitet.getNaziv());
                    }
                }
            }
        }
        // Treba to bolje odraditi, krivo mi sto sam nekad glup
        List<Sastojak> sastojci = entitet.getSastojci();
        if (sastojci != null) {
            for (int i = 0; i < sastojci.size(); i++) {
                List<Alergen> alergeni = sastojci.get(i).getAlergeniSastojak();
                for (Alergen a : alergeni) {
                    if (entitet.getId().equals(a.getId())) {
                        throw new Iznimka("<html>Nemoguće obrisati, neki sastojci<br>imaju alergen " + entitet.getNaziv());
                    }
                }

            }
        }
    }

}
