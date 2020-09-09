/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.pejic.zavrsnirad.model;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 *
 * @author Pejić
 */
@Entity
public class Alergen extends AttributeNaziv {
        
    private String opis;
                  
    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
        
    
}
