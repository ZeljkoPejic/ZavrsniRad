/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.pejic.zavrsnirad.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author Pejić
 */

@MappedSuperclass
public abstract class Entitet {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="sifra")
    private Long id; 

    public Long getId() {
        return id;
    }
    
    
}
