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
public class Sastojak extends AttributeNaziv{
    
    @ManyToMany
    @JoinTable(
        name = "alergen_sastojak", 
        joinColumns = @JoinColumn(name = "sastojak"), 
        inverseJoinColumns = @JoinColumn(name = "alergen")
    )
    private List<Alergen> alergeniSastojak = new ArrayList<>();

    public List<Alergen> getAlergeniSastojak() {
        return alergeniSastojak;
    }

    public void setAlergeniSastojak(List<Alergen> alergeniSastojak) {
        this.alergeniSastojak = alergeniSastojak;
    }

    @Override
    public String toString() {
        return naziv;
    }
    
    
           
}
