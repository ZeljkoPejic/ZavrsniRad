/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.pejic.zavrsnirad.start;

import hr.pejic.zavrsnirad.utility.HibernateUtility;

/**
 *
 * @author ...
 */
public class Start {
    
    public static void main(String[] args) {
        HibernateUtility.getSessionFactory().openSession();
    }
    
}
