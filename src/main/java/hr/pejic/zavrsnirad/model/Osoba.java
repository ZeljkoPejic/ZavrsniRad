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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
    @JoinTable(
        name = "osoba_alergen", 
        joinColumns = @JoinColumn(name = "osoba"), 
        inverseJoinColumns = @JoinColumn(name = "alergen")
    )
    private List<Alergen> alergeniOsobe = new ArrayList<>();

    public List<Alergen> getAlergeniOsobe() {
        return alergeniOsobe;
    }

    public void setAlergeniOsobe(List<Alergen> alergeniOsobe) {
        this.alergeniOsobe = alergeniOsobe;
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

    @Override
    public String toString() {
        return ime + " " + prezime;
    }
         
    
}
