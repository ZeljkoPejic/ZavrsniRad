/*
 * To change this license header, choose Licens     @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
e Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.pejic.zavrsnirad.view;

import hr.pejic.zavrsnirad.controller.ObradaRecept;
import hr.pejic.zavrsnirad.controller.ObradaSastojak;
import hr.pejic.zavrsnirad.model.Recept;
import hr.pejic.zavrsnirad.model.Sastojak;
import hr.pejic.zavrsnirad.utility.Iznimka;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import hr.pejic.zavrsnirad.utility.BrisanjePoruke;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;

/**
 *
 * @author Pejić
 */
public class ReceptProzor extends javax.swing.JFrame {

    private final ObradaRecept or;
    private final ObradaSastojak os;
    private Recept recept;

    /**
     * Creates new form ReceptProzor
     */
    public ReceptProzor() {
        initComponents();
        or = new ObradaRecept();
        os = new ObradaSastojak();
        setTitle(Recept.class.getSimpleName());
        ucitajRecepte();
        ucitajSastojke();
        lblIkona.setText("\ud83d\udd0d");
        setIconImage(new ImageIcon("Slike" + File.separator + "recept.jpg").getImage().getScaledInstance(20, 15, Image.SCALE_AREA_AVERAGING));
    }

    private void ucitajRecepte() {
        DefaultListModel<Recept> m = new DefaultListModel<>();
        or.ispis().forEach(r -> m.addElement(r));
        lstReceptiUBazi.setModel(m);
    }

    private void traziRecepte() {
        DefaultListModel<Recept> m = new DefaultListModel<>();
        or.ispis().forEach(r -> m.addElement(r));
        lstReceptiUBazi.setModel(m);
    }

    private void ucitajSastojke() {
        DefaultListModel<Sastojak> m = new DefaultListModel<>();
        os.ispis(txtTraziAlergen.getText()).forEach(s -> m.addElement(s));
        lstSastojciUBazi.setModel(m);
    }

    private void traziSastojke() {
        DefaultListModel<Sastojak> m = new DefaultListModel<>();
        os.ispis().forEach(s -> m.addElement(s));
        lstSastojciUBazi.setModel(m);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtNaziv = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstReceptiUBazi = new javax.swing.JList<>();
        pnlObrada = new javax.swing.JPanel();
        btnObrada = new javax.swing.JButton();
        btnObrada.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Zahvalnica().setVisible(true);
            }

        });
        lblKreiraj = new javax.swing.JLabel();
        lblKreiraj.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblKreiraj.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                recept = new Recept();
                recept.setNaziv(txtNaziv.getText());
                or.setEntitet(recept);
                try{
                    or.kreiraj();
                    lblIznimka.setText("<html>Recept "+recept.getNaziv()+"<br> je uspjepšno kreiran");
                    ucitajRecepte();
                    new BrisanjePoruke(lblIznimka).start();
                }catch(Iznimka ex){
                    lblIznimka.setText(ex.getPoruka());
                }

            }
        });
        lblIzmjena = new javax.swing.JLabel();
        lblIzmjena.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblIzmjena.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                recept = lstReceptiUBazi.getSelectedValue();
                if(recept==null){
                    lblIznimka.setText("<html>Odaberite recept<br>za izmjenu");
                    return;
                }
                String naziv = recept.getNaziv();
                recept.setNaziv(txtNaziv.getText());
                or.setEntitet(recept);
                try{
                    or.azuriraj();
                    lblIznimka.setText("<html>Recept "+naziv+"<br>je uspjepšno<br>ažuriran u "+recept.getNaziv());
                    ucitajRecepte();
                    new BrisanjePoruke(lblIznimka).start();
                }catch(Iznimka ex){
                    lblIznimka.setText(ex.getPoruka());
                }

            }
        });
        lblBrisanje = new javax.swing.JLabel();
        lblBrisanje.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblBrisanje.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                recept = lstReceptiUBazi.getSelectedValue();
                if(recept==null){
                    lblIznimka.setText("<html>Odaberite recept<br>za brisanje");
                    return;
                }
                String naziv = recept.getNaziv();
                or.setEntitet(recept);
                try{
                    or.obrisi();
                    lblIznimka.setText("<html>Recept "+naziv+"<br>je uspjepšno<br>obrisan");
                    ucitajRecepte();
                    new BrisanjePoruke(lblIznimka).start();
                }catch(Iznimka ex){
                    lblIznimka.setText(ex.getPoruka());
                }

            }
        });
        lblIznimka = new javax.swing.JLabel();
        txtTraziRecept = new javax.swing.JTextField();
        lblIkona = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstSastojciUBazi = new javax.swing.JList<>();
        txtTraziAlergen = new javax.swing.JTextField();
        lblIkona1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstSastojciRecepta = new javax.swing.JList<>();
        lblPoruka = new javax.swing.JLabel();
        btnDodaj = new javax.swing.JButton();
        btnDodaj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recept = lstReceptiUBazi.getSelectedValue();
                if(recept==null){
                    lblPoruka.setText("Odaberite recept");
                    return;
                }
                List<Sastojak> sastojci = lstSastojciUBazi.getSelectedValuesList();
                if(sastojci.isEmpty()){
                    lblPoruka.setText("Odaberite sastojke koje želite dodijeliti receptu "+recept.getNaziv());
                    return;
                }
                DefaultListModel<Sastojak> model = new DefaultListModel<>();
                try{        
                    or.setEntitet(recept);
                    or.azurirajSastojakRecepta(sastojci);
                    recept.getSastojciRecepta().forEach(s -> model.addElement(s));
                    lstSastojciRecepta.setModel(model);
                    lblPoruka.setText("Receptu " + recept.getNaziv() + " uspješno je dodijeljen sastojak");
                    new BrisanjePoruke(lblPoruka).start();
                }catch(Iznimka ex){
                    lblPoruka.setText(ex.getPoruka());
                }
            }
        });
        btnUkloni = new javax.swing.JButton();
        btnUkloni.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recept = lstReceptiUBazi.getSelectedValue();
                if (recept == null) {
                    lblPoruka.setText("Odaberite recept za uklanjanje recepta");
                    return;
                }
                DefaultListModel<Sastojak> sastojciRecepta = (DefaultListModel<Sastojak>) lstSastojciRecepta.getModel();
                if (sastojciRecepta.isEmpty()) {
                    lblPoruka.setText("Recept nema niti jedan dodijeljen sastojak za obrisati");
                    return;
                }
                List<Sastojak> selektiraniSastojci = lstSastojciRecepta.getSelectedValuesList();
                if (selektiraniSastojci.isEmpty()) {
                    lblPoruka.setText("Odaberite sastojak koje želite ukloniti");
                    return;
                }
                for (int i = 0; i < selektiraniSastojci.size(); i++) {

                    for (int j = 0; j < sastojciRecepta.size(); j++) {

                        if (selektiraniSastojci.get(i).equals(sastojciRecepta.getElementAt(j))) {
                            recept.getSastojciRecepta().remove(sastojciRecepta.getElementAt(j));
                            sastojciRecepta.removeElementAt(j);
                            break;

                        }
                    }
                }
                or.setEntitet(recept);
                or.obrisiSastojakRecepta();
                lblPoruka.setText("Receptu " + recept.getNaziv() + " je uspješno obrisan sastojak");
                new BrisanjePoruke(lblPoruka).start();

            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Naziv");

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("Recepti"));

        lstReceptiUBazi.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstReceptiUBazi.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstReceptiUBaziValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstReceptiUBazi);

        pnlObrada.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnObrada.setText("Obrada");

        lblKreiraj.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblKreiraj.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblKreiraj.setText("Kreiraj");

        lblIzmjena.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblIzmjena.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIzmjena.setText("Izmjena");

        lblBrisanje.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblBrisanje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBrisanje.setText("Brisanje");

        javax.swing.GroupLayout pnlObradaLayout = new javax.swing.GroupLayout(pnlObrada);
        pnlObrada.setLayout(pnlObradaLayout);
        pnlObradaLayout.setHorizontalGroup(
            pnlObradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlObradaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlObradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblKreiraj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblIzmjena, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblBrisanje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnObrada, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlObradaLayout.setVerticalGroup(
            pnlObradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlObradaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblKreiraj)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblIzmjena)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblBrisanje)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnObrada)
                .addContainerGap())
        );

        lblIznimka.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIznimka.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        txtTraziRecept.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTraziReceptKeyReleased(evt);
            }
        });

        lblIkona.setText("Icon");

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder("Sastojci u bazi"));

        jScrollPane2.setViewportView(lstSastojciUBazi);

        txtTraziAlergen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTraziAlergenKeyReleased(evt);
            }
        });

        lblIkona1.setText("Icon");

        jScrollPane3.setBorder(javax.swing.BorderFactory.createTitledBorder("Sastojci recepta"));

        jScrollPane3.setViewportView(lstSastojciRecepta);

        btnDodaj.setText("Dodaj");

        btnUkloni.setText("Ukloni");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblIkona, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTraziRecept, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIznimka, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlObrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPoruka, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblIkona1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtTraziAlergen))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnDodaj)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnUkloni)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtTraziRecept, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblIkona))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pnlObrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblIznimka, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTraziAlergen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblIkona1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnDodaj)
                                    .addComponent(btnUkloni)))
                            .addComponent(jScrollPane2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblPoruka, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lstReceptiUBaziValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstReceptiUBaziValueChanged

        recept = lstReceptiUBazi.getSelectedValue();
        if (recept == null) {
            return;
        }
        txtNaziv.setText(recept.getNaziv());
        DefaultListModel<Sastojak> prazniModel = new DefaultListModel<>();
        DefaultListModel<Sastojak> modelAlergena = (DefaultListModel<Sastojak>) lstSastojciUBazi.getModel();
        int[] indices = new int[recept.getSastojciRecepta().size()];
        int index = 0;
        for (Sastojak s : recept.getSastojciRecepta()) {
            for (int i = 0; i < modelAlergena.size(); i++) {
                if (s.getId().equals(modelAlergena.getElementAt(i).getId())) {
                    indices[index++] = i;
                    break;
                }
            }
            prazniModel.addElement(s);
        }
        lstSastojciUBazi.setModel(modelAlergena);
        lstSastojciUBazi.setSelectedIndices(indices);

        lstSastojciRecepta.setModel(prazniModel);

    }//GEN-LAST:event_lstReceptiUBaziValueChanged

    private void txtTraziReceptKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTraziReceptKeyReleased
        traziRecepte();
    }//GEN-LAST:event_txtTraziReceptKeyReleased

    private void txtTraziAlergenKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTraziAlergenKeyReleased
        traziSastojke();
    }//GEN-LAST:event_txtTraziAlergenKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnObrada;
    private javax.swing.JButton btnUkloni;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblBrisanje;
    private javax.swing.JLabel lblIkona;
    private javax.swing.JLabel lblIkona1;
    private javax.swing.JLabel lblIzmjena;
    private javax.swing.JLabel lblIznimka;
    private javax.swing.JLabel lblKreiraj;
    private javax.swing.JLabel lblPoruka;
    private javax.swing.JList<Recept> lstReceptiUBazi;
    private javax.swing.JList<Sastojak> lstSastojciRecepta;
    private javax.swing.JList<Sastojak> lstSastojciUBazi;
    private javax.swing.JPanel pnlObrada;
    private javax.swing.JTextField txtNaziv;
    private javax.swing.JTextField txtTraziAlergen;
    private javax.swing.JTextField txtTraziRecept;
    // End of variables declaration//GEN-END:variables
}
