/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.pejic.zavrsnirad.utility;

/**
 *
 * @author Pejić
 */
public class Iznimka extends Exception{
    
    private String poruka;

    public Iznimka(String poruka) {
        this.poruka = poruka;
    }
    
    public String getPoruka(){
        return poruka;
    }
    
    
    
}
