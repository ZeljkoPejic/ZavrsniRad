/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.pejic.zavrsnirad.view;

import hr.pejic.zavrsnirad.controller.ObradaAlergen;
import hr.pejic.zavrsnirad.controller.ObradaRecept;
import hr.pejic.zavrsnirad.controller.ObradaSastojak;
import hr.pejic.zavrsnirad.model.Alergen;
import hr.pejic.zavrsnirad.model.Recept;
import hr.pejic.zavrsnirad.model.Sastojak;
import hr.pejic.zavrsnirad.utility.BrisanjePoruke;
import hr.pejic.zavrsnirad.utility.Iznimka;
import hr.pejic.zavrsnirad.utility.PomocneMetode;
import java.awt.Image;
import java.io.File;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;

/**
 *
 * @author Pejić
 */
public class SastojakProzor extends javax.swing.JFrame {

    private Sastojak sastojak;
    private final ObradaSastojak os;
    private final ObradaAlergen oa;

    /**
     * Creates new form SastojakProzor
     */
    public SastojakProzor() {
        initComponents();
        os = new ObradaSastojak();
        oa = new ObradaAlergen();
        setTitle(Sastojak.class.getSimpleName());
        ucitajSvePodatke();
        lstAlergeniSastojka.setModel(new DefaultListModel<>());
        lblIkona.setText("\ud83d\udd0d");
        lblIkona1.setText("\ud83d\udd0d");
        setIconImage(new ImageIcon("Slike" + File.separator + "sastojci.jpg").getImage().getScaledInstance(20, 15, Image.SCALE_AREA_AVERAGING));
        txtTraziSastojak.setToolTipText("Unesi sastojak koji želiš tražiti");

    }

    private void kreiraj() {
        sastojak = new Sastojak();
        sastojak.setNaziv(txtNaziv.getText());
        
        try {
            os.setEntitet(sastojak);
            os.kreiraj();
            lblPoruka.setText("Sastojak " + sastojak.getNaziv() + " je uspješno kreiran");
            ucitajSastojke();            
            PomocneMetode.ocistiPolja(getContentPane());
            new BrisanjePoruke(lblPoruka).start();
        } catch (Iznimka ex) {
            lblPoruka.setText(ex.getPoruka());
        }
    }

    private void izmjena() {
        sastojak = lstSastojak.getSelectedValue();
        if (sastojak == null) {
            lblPoruka.setText("Odaberite sastojak za izmjenu");
            return;
        }
        String naziv = sastojak.getNaziv();
        sastojak.setNaziv(txtNaziv.getText());
        os.setEntitet(sastojak);
        try {
            os.azuriraj();
            lblPoruka.setText("Sastojak " + naziv + " je uspješno ažuriran u " + sastojak.getNaziv());
            ucitajSastojke();
            PomocneMetode.ocistiPolja(getContentPane());
            new BrisanjePoruke(lblPoruka).start();
        } catch (Iznimka ex) {
            lblPoruka.setText(ex.getPoruka());
        }

    }

    private void obrisi() {
        sastojak = lstSastojak.getSelectedValue();
        if (sastojak == null) {
            lblPoruka.setText("Odaberite sastojak za brisanje");
            return;
        }
        os.setEntitet(sastojak);
        try {
            os.obrisi();
            ucitajSastojke();
            lblPoruka.setText("Sastojak " + txtNaziv.getText() + " je uspješno obrisan ");
            PomocneMetode.ocistiPolja(getContentPane());
            new BrisanjePoruke(lblPoruka).start();
        } catch (Iznimka ex) {
            lblPoruka.setText(ex.getPoruka());
        }

    }

    private void ucitajSastojke() {
        DefaultListModel<Sastojak> model = new DefaultListModel<>();
        os.ispis().forEach(s -> model.addElement(s));
        lstSastojak.setModel(model);
    }

    private void traziSastojke() {
        DefaultListModel<Sastojak> model = new DefaultListModel<>();
        os.ispis(txtTraziSastojak.getText()).forEach(s -> model.addElement(s));
        lstSastojak.setModel(model);
    }

    private void ucitajAlergene() {
        DefaultListModel<Alergen> model = new DefaultListModel<>();
        oa.ispis().forEach(a -> model.addElement(a));
        lstAlergeniUBazi.setModel(model);
    }

    private void traziAlergene() {
        DefaultListModel<Alergen> model = new DefaultListModel<>();
        oa.ispis(txtTraziAlergenBaza.getText()).forEach(a -> model.addElement(a));
        lstAlergeniUBazi.setModel(model);
    }
    
    private void ucitajSvePodatke(){
        ucitajSastojke();
        ucitajAlergene();
        
        DefaultComboBoxModel<Recept> cbr = new DefaultComboBoxModel<>();
        ObradaRecept or = new ObradaRecept();
        Recept recept;
        or.ispis().forEach(o -> cbr.addElement(o));
        if (cbr.getSize() != 0) {
            DefaultListModel<Sastojak> lstSR = new DefaultListModel<>(); //listaSastojakRecept
            recept = (Recept) cbr.getSelectedItem();
            recept.getSastojciRecepta().forEach(a -> lstSR.addElement(a));
            lstSastojciRecepta.setModel(lstSR);
        }
        cbRecept.setModel(cbr);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblIkona = new javax.swing.JLabel();
        txtTraziSastojak = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstSastojak = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        txtNaziv = new javax.swing.JTextField();
        sliderIzbor = new javax.swing.JSlider();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnOdradiRadnju = new javax.swing.JButton();
        lblPoruka = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstAlergeniUBazi = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstAlergeniSastojka = new javax.swing.JList<>();
        lblIkona1 = new javax.swing.JLabel();
        txtTraziAlergenBaza = new javax.swing.JTextField();
        btnDodaj = new javax.swing.JButton();
        btnUkloni = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        lstSastojciRecepta = new javax.swing.JList<>();
        cbRecept = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        lblIkona.setText("Icon");

        txtTraziSastojak.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTraziSastojakKeyReleased(evt);
            }
        });

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("Sastojci"));

        lstSastojak.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstSastojak.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstSastojakValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstSastojak);

        jLabel1.setText("Naziv");

        sliderIzbor.setMaximum(2);
        sliderIzbor.setToolTipText("Izaberite radnju");
        sliderIzbor.setValue(0);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Kreiraj");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Izmjena");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("Brisanje");

        btnOdradiRadnju.setText("Obrada");
        btnOdradiRadnju.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOdradiRadnjuActionPerformed(evt);
            }
        });

        lblPoruka.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder("Alergeni u bazi"));

        jScrollPane2.setViewportView(lstAlergeniUBazi);

        jScrollPane3.setBorder(javax.swing.BorderFactory.createTitledBorder("Alergen u sastojku"));

        jScrollPane3.setViewportView(lstAlergeniSastojka);

        lblIkona1.setText("Icon");

        txtTraziAlergenBaza.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTraziAlergenBazaKeyReleased(evt);
            }
        });

        btnDodaj.setText(">>");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        btnUkloni.setText("<<");
        btnUkloni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUkloniActionPerformed(evt);
            }
        });

        jScrollPane4.setBorder(javax.swing.BorderFactory.createTitledBorder("Sastojci"));

        jScrollPane4.setViewportView(lstSastojciRecepta);

        cbRecept.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbReceptItemStateChanged(evt);
            }
        });

        jLabel5.setText("Recept:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblIkona)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTraziSastojak, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1)
                    .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPoruka, javax.swing.GroupLayout.DEFAULT_SIZE, 645, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(36, 36, 36)
                                .addComponent(jLabel3)
                                .addGap(33, 33, 33)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(btnOdradiRadnju))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(sliderIzbor, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblIkona1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTraziAlergenBaza))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnUkloni, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbRecept, 0, 100, Short.MAX_VALUE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPoruka, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblIkona)
                        .addComponent(txtTraziSastojak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(btnDodaj)
                        .addGap(46, 46, 46)
                        .addComponent(btnUkloni))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane4)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(sliderIzbor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(26, 26, 26)
                                .addComponent(btnOdradiRadnju))
                            .addComponent(jScrollPane2)
                            .addComponent(jScrollPane3))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblIkona1)
                        .addComponent(txtTraziAlergenBaza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbRecept, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lstSastojakValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstSastojakValueChanged

        sastojak = lstSastojak.getSelectedValue();
        if (sastojak == null) {
            return;
        }
        txtNaziv.setText(sastojak.getNaziv());
        DefaultListModel<Alergen> prazniModel = new DefaultListModel<>();
        DefaultListModel<Alergen> modelAlergena = (DefaultListModel<Alergen>) lstAlergeniUBazi.getModel();
        int[] indices = new int[sastojak.getAlergeniSastojak().size()];
        int index = 0;
        for (Alergen a : sastojak.getAlergeniSastojak()) {
            for (int i = 0; i < modelAlergena.size(); i++) {
                if (a.getId().equals(modelAlergena.getElementAt(i).getId())) {
                    indices[index++] = i;                   
                    break;
                }
            }
            prazniModel.addElement(a);
        }        
        lstAlergeniUBazi.setModel(modelAlergena);
        lstAlergeniUBazi.setSelectedIndices(indices);

        lstAlergeniSastojka.setModel(prazniModel);


    }//GEN-LAST:event_lstSastojakValueChanged

    private void btnOdradiRadnjuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOdradiRadnjuActionPerformed

        switch (sliderIzbor.getValue()) {
            case 0 -> {
                kreiraj();
                break;
            }
            case 1 -> {
                izmjena();
                break;
            }
            case 2 -> {
                obrisi();
                break;
            }
        }
    }//GEN-LAST:event_btnOdradiRadnjuActionPerformed

    private void txtTraziSastojakKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTraziSastojakKeyReleased
        traziSastojke();
    }//GEN-LAST:event_txtTraziSastojakKeyReleased

    private void txtTraziAlergenBazaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTraziAlergenBazaKeyReleased
        traziAlergene();
    }//GEN-LAST:event_txtTraziAlergenBazaKeyReleased

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed

        sastojak = lstSastojak.getSelectedValue();
        if (sastojak == null) {
            lblPoruka.setText("Odaberite sastojak");
            return;
        }
        List<Alergen> alergeni = lstAlergeniUBazi.getSelectedValuesList();
        if (alergeni.isEmpty()) {
            lblPoruka.setText("Odaberite alergen koji želite dodati odabranome sastojku");
            return;
        }
        DefaultListModel<Alergen> model = new DefaultListModel<>();

        try {
            os.setEntitet(sastojak);
            os.azurirajAlergenSastojka(alergeni);
            sastojak.getAlergeniSastojak().forEach(a -> model.addElement(a));
            lstAlergeniSastojka.setModel(model);
            lblPoruka.setText("Sastojku " + sastojak.getNaziv() + " uspješno je dodijeljen alergen");
            new BrisanjePoruke(lblPoruka).start();
        } catch (Iznimka ex) {
            lblPoruka.setText(ex.getPoruka());
        }
        
    }//GEN-LAST:event_btnDodajActionPerformed

    private void btnUkloniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUkloniActionPerformed

        sastojak = lstSastojak.getSelectedValue();
        if (sastojak == null) {
            lblPoruka.setText("Odaberite sastojak za uklanjanje alergena");
            return;
        }
        DefaultListModel<Alergen> alergeniSastojka = (DefaultListModel<Alergen>) lstAlergeniSastojka.getModel();
        if (alergeniSastojka.isEmpty()) {
            lblPoruka.setText("Sastojak nema niti jedan dodijeljen alergen za obrisati");
            return;
        }
        List<Alergen> selektiraniAlergeni = lstAlergeniSastojka.getSelectedValuesList();
        if (selektiraniAlergeni.isEmpty()) {
            lblPoruka.setText("Odaberite alergen/e koje želite ukloniti");
            return;
        }
        for (int i = 0; i < selektiraniAlergeni.size(); i++) {

            for (int j = 0; j < alergeniSastojka.size(); j++) {

                if (selektiraniAlergeni.get(i).equals(alergeniSastojka.getElementAt(j))) {
                    sastojak.getAlergeniSastojak().remove(alergeniSastojka.getElementAt(j));
                    alergeniSastojka.removeElementAt(j);
                    break;

                }
            }
        }
        os.setEntitet(sastojak);
        os.obrisiAlergenSastojka();
        lblPoruka.setText("Sastojku " + sastojak.getNaziv() + " je uspješno obrisan alergen");
        new BrisanjePoruke(lblPoruka).start();

    }//GEN-LAST:event_btnUkloniActionPerformed

    private void cbReceptItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbReceptItemStateChanged
        Recept recept = (Recept) cbRecept.getSelectedItem();        
        DefaultListModel<Sastojak> m = new DefaultListModel<>();
        recept.getSastojciRecepta().forEach(s -> m.addElement(s));
        lstSastojciRecepta.setModel(m);
    }//GEN-LAST:event_cbReceptItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnOdradiRadnju;
    private javax.swing.JButton btnUkloni;
    private javax.swing.JComboBox<Recept> cbRecept;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblIkona;
    private javax.swing.JLabel lblIkona1;
    private javax.swing.JLabel lblPoruka;
    private javax.swing.JList<Alergen> lstAlergeniSastojka;
    private javax.swing.JList<Alergen> lstAlergeniUBazi;
    private javax.swing.JList<Sastojak> lstSastojak;
    private javax.swing.JList<Sastojak> lstSastojciRecepta;
    private javax.swing.JSlider sliderIzbor;
    private javax.swing.JTextField txtNaziv;
    private javax.swing.JTextField txtTraziAlergenBaza;
    private javax.swing.JTextField txtTraziSastojak;
    // End of variables declaration//GEN-END:variables
}
