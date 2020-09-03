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
public class Sastojak extends Entitet{
    
    @Column(nullable = false)
    private String naziv;
    
    @ManyToMany
    private List<Alergen> alergeni = new ArrayList<>();

    public List<Alergen> getAlergeni() {
        return alergeni;
    }

    public void setAlergeni(List<Alergen> alergeni) {
        this.alergeni = alergeni;
    }
        
    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
        
}
