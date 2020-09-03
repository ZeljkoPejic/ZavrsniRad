/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.pejic.zavrsnirad.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

/**
 *
 * @author Pejić
 */
@Entity
public class Osoba extends Entitet{
    
    @Column(nullable = false)
    private String ime;
    @Column(nullable = false)
    private String prezime;
    private String oib;
    
    @ManyToMany
    private List<Alergen> alergeni = new ArrayList<>();

    public List<Alergen> getAlergen() {
        return alergeni;
    }

    public void setAlergen(List<Alergen> alergen) {
        this.alergeni = alergen;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getOib() {
        return oib;
    }

    public void setOib(String oib) {
        this.oib = oib;
    }
         
    
}
