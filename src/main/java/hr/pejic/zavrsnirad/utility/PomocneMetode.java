/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.pejic.zavrsnirad.utility;

import java.awt.Component;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author Pejić
 */
public class PomocneMetode {

    public static boolean provjeraOib(String oib) {

        if (oib.length() != 11) {
            return false;
        }

        try {
            Long.parseLong(oib);
        } catch (NumberFormatException e) {
            return false;
        }

        int a = 10;
        for (int i = 0; i < 10; i++) {
            a = a + Integer.parseInt(oib.substring(i, i + 1));
            a = a % 10;
            if (a == 0) {
                a = 10;
            }
            a *= 2;
            a = a % 11;
        }
        int kontrolni = 11 - a;
        if (kontrolni == 10) {
            kontrolni = 0;
        }
        return kontrolni == Integer.parseInt(oib.substring(10));
    }

    public static void ocistiPolja(Container container) {

        Component[] com = container.getComponents();
        for (Component a : com) {
            if (a.getClass().isInstance(new JTextField())) {
                ((JTextField) a).setText("");
            }
        }

    }

}
