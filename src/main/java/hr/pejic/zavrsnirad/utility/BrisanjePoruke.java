/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.pejic.zavrsnirad.utility;

import javax.swing.JLabel;

/**
 *
 * @author Pejić
 */
public class BrisanjePoruke extends Thread {

    private JLabel poruka;

    public BrisanjePoruke(JLabel poruka) {
        this.poruka = poruka;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3 * 1000);
        } catch (InterruptedException ex) {

        }
        poruka.setText("");
    }

}
