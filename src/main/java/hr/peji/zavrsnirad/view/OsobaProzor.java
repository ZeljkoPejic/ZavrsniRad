/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.peji.zavrsnirad.view;

import hr.pejic.zavrsnirad.controller.ObradaOsoba;
import hr.pejic.zavrsnirad.model.Alergen;
import hr.pejic.zavrsnirad.model.Osoba;
import hr.pejic.zavrsnirad.utility.BrisanjePoruke;
import hr.pejic.zavrsnirad.utility.Iznimka;
import java.awt.Image;
import java.io.File;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;

/**
 *
 * @author Pejić
 */
public class OsobaProzor extends javax.swing.JFrame {

    private Osoba osoba;
    private ObradaOsoba oo;

    /**
     * Creates new form OsobeProzor
     */
    public OsobaProzor() {
        initComponents();
        oo = new ObradaOsoba();
        ucitajOsobe();
        lblIkona.setText("\ud83d\udd0d");
        setTitle(Osoba.class.getSimpleName());
        setIconImage(new ImageIcon("Slike"+File.separator+"osobe2.jpg").getImage().getScaledInstance(20, 15, Image.SCALE_AREA_AVERAGING));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtIme = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPrezime = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtOib = new javax.swing.JTextField();
        btnKreiraj = new javax.swing.JButton();
        btnIzmjena = new javax.swing.JButton();
        btnBrisanje = new javax.swing.JButton();
        lblIznimka = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstAlergen = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstOsoba = new javax.swing.JList<>();
        txtTraziOsobu = new javax.swing.JTextField();
        lblIkona = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Podaci"));

        jLabel1.setText("Ime");

        jLabel2.setText("Prezime");

        jLabel3.setText("OIB");

        btnKreiraj.setText("Dodaj");
        btnKreiraj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKreirajActionPerformed(evt);
            }
        });

        btnIzmjena.setText("Izmjena");
        btnIzmjena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmjenaActionPerformed(evt);
            }
        });

        btnBrisanje.setText("Brisanje");

        lblIznimka.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIznimka, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel1)
                                .addComponent(txtIme)
                                .addComponent(jLabel2)
                                .addComponent(txtPrezime, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addComponent(txtOib))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnIzmjena)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBrisanje))
                            .addComponent(btnKreiraj))
                        .addGap(0, 1, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtOib, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIzmjena)
                    .addComponent(btnBrisanje))
                .addGap(18, 18, 18)
                .addComponent(btnKreiraj)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblIznimka, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                .addContainerGap())
        );

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("Alergeni u bazi"));

        jScrollPane1.setViewportView(lstAlergen);

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder("Osobe"));

        lstOsoba.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstOsobaValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(lstOsoba);

        txtTraziOsobu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTraziOsobuKeyReleased(evt);
            }
        });

        lblIkona.setText("Icon");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblIkona)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTraziOsobu, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)))
                .addGap(154, 154, 154)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTraziOsobu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblIkona))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lstOsobaValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstOsobaValueChanged

        if (evt.getValueIsAdjusting()) {
            return;
        }
        osoba = lstOsoba.getSelectedValue();
        if (osoba == null) {
            return;
        }

        txtIme.setText(osoba.getIme());
        txtPrezime.setText(osoba.getPrezime());
        txtOib.setText(osoba.getOib());


    }//GEN-LAST:event_lstOsobaValueChanged

    private void btnKreirajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKreirajActionPerformed

        new OsobaKreirajProzor().setVisible(true);

    }//GEN-LAST:event_btnKreirajActionPerformed

    private void btnIzmjenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmjenaActionPerformed

        osoba = lstOsoba.getSelectedValue();

        osoba.setIme(txtIme.getText());
        osoba.setPrezime(txtPrezime.getText());
        osoba.setOib(txtOib.getText());
        oo.setEntitet(osoba);

        try {
            oo.azuriraj();
            lblIznimka.setText("Uspješna izmjena osobe");
            BrisanjePoruke bp = new BrisanjePoruke(lblIznimka);
            bp.start();
        } catch (Iznimka ex) {
            lblIznimka.setText(ex.getPoruka());
        }

    }//GEN-LAST:event_btnIzmjenaActionPerformed

    private void txtTraziOsobuKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTraziOsobuKeyReleased
        traziOsobe();
    }//GEN-LAST:event_txtTraziOsobuKeyReleased

    private void ucitajOsobe() {

        DefaultListModel<Osoba> m = new DefaultListModel<>();

        oo.ispis().forEach(s -> m.addElement(s));

        lstOsoba.setModel(m);

    }

    private void traziOsobe() {
        DefaultListModel<Osoba> m = new DefaultListModel<>();

        oo.ispis(txtTraziOsobu.getText()).forEach(s -> m.addElement(s));
        lstOsoba.setModel(m);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBrisanje;
    private javax.swing.JButton btnIzmjena;
    private javax.swing.JButton btnKreiraj;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblIkona;
    private javax.swing.JLabel lblIznimka;
    private javax.swing.JList<Alergen> lstAlergen;
    private javax.swing.JList<Osoba> lstOsoba;
    private javax.swing.JTextField txtIme;
    private javax.swing.JTextField txtOib;
    private javax.swing.JTextField txtPrezime;
    private javax.swing.JTextField txtTraziOsobu;
    // End of variables declaration//GEN-END:variables
}
