/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.pejic.zavrsnirad.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

/**
 *
 * @author Pejić
 */
@Entity
public class Alergen extends AttributeNaziv {
        
    private String opis;
    
    @ManyToMany(mappedBy = "alergeniOsobe")
    private List<Osoba> osobe = new ArrayList<>();
    
    @ManyToMany(mappedBy = "alergeniSastojak")
    private List<Sastojak> sastojci = new ArrayList<>();

    public List<Sastojak> getSastojci() {
        return sastojci;
    }

    public void setSastojci(List<Sastojak> sastojci) {
        this.sastojci = sastojci;
    }
                      
    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    @Override
    public String toString() {
        return naziv;
    }

    public List<Osoba> getOsobe() {
        return osobe;
    }

    public void setOsobe(List<Osoba> osobe) {
        this.osobe = osobe;
    }
    
    
        
    
}
