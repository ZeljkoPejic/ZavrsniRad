/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.pejic.zavrsnirad.testiranje;

import hr.pejic.zavrsnirad.controller.ObradaAlergen;
import hr.pejic.zavrsnirad.controller.ObradaOsoba;
import hr.pejic.zavrsnirad.model.Alergen;
import hr.pejic.zavrsnirad.model.Osoba;
import hr.pejic.zavrsnirad.utility.Iznimka;

/**
 *
 * @author Pejić
 */
public class Test {
    
    public static void main(String[] args) {
        
        
//        Osoba osoba = new Osoba();
//        
//        osoba.setIme("Pero");
//        osoba.setPrezime("12345j");
//        osoba.setOib("22222222222");
//        
//        ObradaOsoba oo = new ObradaOsoba();
//        
//        oo.setEntitet(osoba);
//        
//        try{
//            oo.kreiraj();
//        }catch(Iznimka e){
//            System.out.println(e.getPoruka());
//        }
                
        Alergen alergen = new Alergen();
        
        alergen.setNaziv("");
        alergen.setOpis("Nešto opisano");
        
        ObradaAlergen oa = new ObradaAlergen();
        
        oa.setEntitet(alergen);
        
        try{
            oa.kreiraj();
        }catch(Iznimka e){
            System.out.println(e.getPoruka());
        }
        
        
        
        
        
        
        
    }
    
}
