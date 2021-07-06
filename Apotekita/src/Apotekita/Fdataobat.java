/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Apotekita;

import com.sun.xml.internal.bind.v2.model.core.ID;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class Fdataobat extends javax.swing.JFrame {

    /**
     * Creates new form Fdataobat
     */
    public Fdataobat() {
        initComponents();
        load_data();
        IDOtomatis();
        LoadKategori();
        LoadJenis();
        
        edit.setEnabled(false);
        delete.setEnabled(false);
    }
    private void load_data(){
        Connection kon=koneksi.koneksiDB();
        Object header[]={"ID OBAT", "NAMA OBAT", "KATEGORI", "JENIS", "MANFAAT", "KANDUNGAN"};
        DefaultTableModel data=new DefaultTableModel(null, header);
        tabelobat.setModel(data);
        String sql_data="SELECT * FROM obat";
        try{
            Statement st=kon.createStatement();
            ResultSet rs=st.executeQuery(sql_data);
            while(rs.next()){
                String d1=rs.getString(1);
                String d2=rs.getString(2);
                String d3=rs.getString(3);
                String d4=rs.getString(4);
                String d5=rs.getString(5);
                String d6=rs.getString(6);
                
                String d[]={d1, d2, d3, d4, d5, d6};
                data.addRow(d);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    private void IDOtomatis(){
        try{
            Connection kon=koneksi.koneksiDB();
            Statement st=kon.createStatement();
            String sql_id="SELECT * FROM obat order by id_obat desc";
            ResultSet rs=st.executeQuery(sql_id);
            if(rs.next()){
                String id_obat=rs.getString("id_obat").substring(1);
                String AN=""+(Integer.parseInt(id_obat)+1);
                String Nol="";
                if(AN.length()==1){
                    Nol="000";
                }else if(AN.length()==2){
                    Nol="00";
                }else if(AN.length()==3){
                    Nol="0";
                }
                id.setText("A"+Nol+AN);
            }else{
                id.setText("A0001");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    private void LoadKategori(){
        try{
            Connection kon=koneksi.koneksiDB();
            Statement st=kon.createStatement();
            String sql_kategori="SELECT * FROM kategori";
            ResultSet rs=st.executeQuery(sql_kategori);
            while(rs.next()){
                kategori.addItem(rs.getString("id_kategori"));
            }
            rs.close();
        }catch(Exception e){
            
        }
    }
    private void NamaKategori(){
        try{
            Connection kon=koneksi.koneksiDB();
            Statement st=kon.createStatement();
            String sql_kategori="SELECT kategori FROM kategori WHERE id_kategori='"+kategori.getSelectedItem()+"'";
            ResultSet rs=st.executeQuery(sql_kategori);
            while(rs.next()){
                Nkategori.setText(rs.getString("kategori"));
            }
        }catch(Exception e){
            
        }
    }
    private void LoadJenis(){
        try{
            Connection kon=koneksi.koneksiDB();
            Statement st=kon.createStatement();
            String sql_jenis="SELECT * FROM jenis";
            ResultSet rs=st.executeQuery(sql_jenis);
            while(rs.next()){
                jenis.addItem(rs.getString("kd_jenis"));
            }
            rs.close();
        }catch(Exception e){
            
        }
    }
    private void NamaJenis(){
        try{
            Connection kon=koneksi.koneksiDB();
            Statement st=kon.createStatement();
            String sql_jenis="SELECT jenis FROM jenis WHERE kd_jenis='"+jenis.getSelectedItem()+"'";
            ResultSet rs=st.executeQuery(sql_jenis);
            while(rs.next()){
                Njenis.setText(rs.getString("jenis"));
            }
        }catch(Exception e){
            
        }
    }
    private void input_data(){
        try{
            Connection kon=koneksi.koneksiDB();
            Statement st=kon.createStatement();
            String sql="INSERT INTO obat values('"+id.getText()
                    +"','"+nama.getText()
                    +"','"+kategori.getSelectedItem()
                    +"','"+jenis.getSelectedItem()
                    +"','"+manfaat.getText()
                    +"','"+kandungan.getText()
                    +"')";
            st.execute(sql);
            JOptionPane.showMessageDialog(null, "Data Obat Berhasil Ditambahkan");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void clear(){
        nama.setText("");
        manfaat.setText("");
        kandungan.setText("");
        kategori.setSelectedItem(1);
        jenis.setSelectedItem(1);
    }
    private void update(){
        try{
            Connection kon=koneksi.koneksiDB();
            Statement st=kon.createStatement();
            String sql_update="UPDATE obat SET nama='"+nama.getText()
                    +"',id_kategori='"+kategori.getSelectedItem()
                    +"',kd_jenis='"+jenis.getSelectedItem()
                    +"',manfaat='"+manfaat.getText()
                    +"',kandungan='"+kandungan.getText()
                    +"'WHERE id_obat='"+id.getText()+"'";
            st.execute(sql_update);
            JOptionPane.showMessageDialog(null, "Data Berhasil Diupdate");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    private void delete(){
        try{
            Connection kon=koneksi.koneksiDB();
            Statement st=kon.createStatement();
            String sql_delete="DELETE from obat WHERE "
                    +"id_obat='"+id.getText()+"'";
            st.executeUpdate(sql_delete);
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
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
        keluar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        nama = new javax.swing.JTextField();
        kategori = new javax.swing.JComboBox<>();
        jenis = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        manfaat = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        kandungan = new javax.swing.JTextArea();
        input = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelobat = new javax.swing.JTable();
        Nkategori = new javax.swing.JTextField();
        Njenis = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel1.setText("KELOLA DATA OBAT APOTEKITA");

        keluar.setText("Keluar");
        keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keluarActionPerformed(evt);
            }
        });

        jLabel2.setText("ID Obat");

        jLabel3.setText("Nama Obat");

        jLabel4.setText("Kategori Obat");

        jLabel5.setText("Jenis Obat");

        jLabel6.setText("Manfaat Obat");

        id.setEnabled(false);

        jLabel7.setText("Kandungan Obat");

        kategori.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kategoriMouseClicked(evt);
            }
        });
        kategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kategoriActionPerformed(evt);
            }
        });

        jenis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jenisActionPerformed(evt);
            }
        });

        manfaat.setColumns(20);
        manfaat.setRows(5);
        jScrollPane1.setViewportView(manfaat);

        kandungan.setColumns(20);
        kandungan.setRows(5);
        jScrollPane2.setViewportView(kandungan);

        input.setText("Input");
        input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputActionPerformed(evt);
            }
        });

        edit.setText("Edit");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        tabelobat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelobat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelobatMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabelobat);

        Nkategori.setEditable(false);

        Njenis.setEditable(false);
        Njenis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NjenisActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(keluar))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(input)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(edit)
                        .addGap(18, 18, 18)
                        .addComponent(delete))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(kategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(50, 50, 50)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Nkategori, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                                    .addComponent(Njenis))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(327, 327, 327)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(kategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Nkategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Njenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(keluar)
                            .addComponent(edit)
                            .addComponent(input)
                            .addComponent(delete)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keluarActionPerformed
        // TODO add your handling code here:
        int keluar; 
        keluar=JOptionPane.showOptionDialog(this,
                "Keluar Dari Kelola Data Obat?",
                "Exit",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, null, null);
        if(keluar==JOptionPane.YES_NO_OPTION)
        {
            new Futamaapoteker().show();
            this.dispose();
        }
    }//GEN-LAST:event_keluarActionPerformed

    private void NjenisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NjenisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NjenisActionPerformed

    private void kategoriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kategoriMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_kategoriMouseClicked

    private void kategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kategoriActionPerformed
        // TODO add your handling code here:
        NamaKategori();
    }//GEN-LAST:event_kategoriActionPerformed

    private void jenisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jenisActionPerformed
        // TODO add your handling code here:
        NamaJenis();
    }//GEN-LAST:event_jenisActionPerformed

    private void inputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputActionPerformed
        // TODO add your handling code here:
        int simpan=JOptionPane.showOptionDialog(this,
                "Apakah data sudah benar? Simpan?",
                "Simpan Data",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,null,null,null);
        if(simpan==JOptionPane.YES_OPTION){
            input_data();
            load_data();
            clear();
            IDOtomatis();
        }
    }//GEN-LAST:event_inputActionPerformed

    private void tabelobatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelobatMouseClicked
        // TODO add your handling code here:
        int bar=tabelobat.getSelectedRow();
        String a=tabelobat.getValueAt(bar, 0).toString();
        String b=tabelobat.getValueAt(bar, 1).toString();
        String c=tabelobat.getValueAt(bar, 2).toString();
        String d=tabelobat.getValueAt(bar, 3).toString();
        String e=tabelobat.getValueAt(bar, 4).toString();
        String f=tabelobat.getValueAt(bar, 5).toString();
        
        id.setText(a);
        nama.setText(b);
        kategori.setSelectedItem(c);
        jenis.setSelectedItem(d);
        manfaat.setText(e);
        kandungan.setText(f);
        
        input.setEnabled(false);
        edit.setEnabled(true);
        delete.setEnabled(true);
    }//GEN-LAST:event_tabelobatMouseClicked

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        // TODO add your handling code here:
        int update=JOptionPane.showOptionDialog(this,
                "Yakin data akan dirubah? Simpan?",
                "Simpan Data",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,null,null,null);
        if(update==JOptionPane.YES_OPTION){
            update();
            load_data();
            clear();
            IDOtomatis();
        }
    }//GEN-LAST:event_editActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
        int delete=JOptionPane.showOptionDialog(this,
                "Yakin data ingin dihapus?",
                "Simpan Data",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,null,null,null);
        if(delete==JOptionPane.YES_OPTION){
            delete();
            load_data();
            clear();
            IDOtomatis();
        }
    }//GEN-LAST:event_deleteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Fdataobat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Fdataobat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Fdataobat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Fdataobat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Fdataobat().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Njenis;
    private javax.swing.JTextField Nkategori;
    private javax.swing.JButton delete;
    private javax.swing.JButton edit;
    private javax.swing.JTextField id;
    private javax.swing.JButton input;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JComboBox<String> jenis;
    private javax.swing.JTextArea kandungan;
    private javax.swing.JComboBox<String> kategori;
    private javax.swing.JButton keluar;
    private javax.swing.JTextArea manfaat;
    private javax.swing.JTextField nama;
    private javax.swing.JTable tabelobat;
    // End of variables declaration//GEN-END:variables
}
