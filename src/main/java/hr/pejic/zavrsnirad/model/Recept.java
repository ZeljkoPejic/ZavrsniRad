/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.pejic.zavrsnirad.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 *
 * @author Pejić
 */
@Entity
public class Recept extends AttributeNaziv{
           
    @ManyToMany
    @JoinTable(
        name = "recept_sastojak", 
        joinColumns = @JoinColumn(name = "recept"), 
        inverseJoinColumns = @JoinColumn(name = "sastojak")
    )
    private List<Sastojak> sastojciRecepta = new ArrayList<>();

    public List<Sastojak> getSastojciRecepta() {
        return sastojciRecepta;
    }

    public void setSastojciRecepta(List<Sastojak> sastojciRecepta) {
        this.sastojciRecepta = sastojciRecepta;
    }

    @Override
    public String toString() {
        return naziv;
    }
    
    
 
}
