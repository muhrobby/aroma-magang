/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Admin.Pengajuan;
import java.sql.*;
import Config.DatabaseConnection;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author muhrobby
 */
public class ListPengajuanSemua extends javax.swing.JDialog {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ListPengajuanSemua.class.getName());

    public String nim;
    /**
     * Creates new form ListPengajuanSemua
     */
    public ListPengajuanSemua(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        
        tampilDataPengajuan();
        totalDiproses();
    }
    
    public void totalDiproses(){
        int total = 0;
        try {
            Connection conn = DatabaseConnection.connect();
            String query = "SELECT COUNT(*) FROM pengajuan WHERE status = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, "diproses");
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                total = rs.getInt(1);
                jLabel2.setText(String.valueOf(total));
            }

            
            } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error ambil data pengajuan : "+ e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void tampilDataPengajuan(){
        try {
            Connection conn = DatabaseConnection.connect();
            String query = "SELECT * FROM pengajuan";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            
            DefaultTableModel model = new DefaultTableModel(new Object[]{"id","nim","nama","prodi","tempat","alamat", "dosen", "status","created_at"}, 0);
            
            while (rs.next()) {                
                model.addRow(new Object[]{
                rs.getInt("id"),
                rs.getString("nim"),
                rs.getString("nama"),
                rs.getString("prodi"),
                rs.getString("tempat"),
                rs.getString("alamat"),
                rs.getString("dosen"),
                rs.getString("status"),
                rs.getDate("created_at")
                });
            }
            tablePengajuan.setModel(model);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error ambil data pengajuan : "+ e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tablePengajuan = new javax.swing.JTable();
        btnEdit = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("PENGAJUAN MAGANG");

        tablePengajuan.setModel(new javax.swing.table.DefaultTableModel(
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
        tablePengajuan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePengajuanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablePengajuan);

        btnEdit.setText("Lihat Detail");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus Data");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Total Pengajuan Status Di Proses");

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("jLabel2");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(89, 89, 89))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 887, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        
        int baris = tablePengajuan.getSelectedRow();
        
        if (baris == -1) {
            JOptionPane.showMessageDialog(this, "Tidak ada data yang di pilih", "PERINGATAN", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int confirm = JOptionPane.showConfirmDialog(this, "Anda yakin ingin mengahpus data ini ? ", "KONFIMASI", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
                    try {
         nim = tablePengajuan.getValueAt(baris, 1).toString();
         Connection conn = DatabaseConnection.connect();
         String sqlDelete = "DELETE FROM pengajuan WHERE nim = ?";
         PreparedStatement stmt = conn.prepareStatement(sqlDelete);
         stmt.setString(1, nim);
         
         int delete = stmt.executeUpdate();
         
                        if (delete > 0) {
                            JOptionPane.showMessageDialog(this, "Data berhasil di hapus");
                            tampilDataPengajuan();
                                    totalDiproses();
                        } else {
                            JOptionPane.showMessageDialog(this, "Gagal menghapus ID tidak di temukan","ERROR",JOptionPane.ERROR_MESSAGE);
                            return;
                        }
         
         
         
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error : "+e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        
        }
        


        
        
    }//GEN-LAST:event_btnHapusActionPerformed

    private void tablePengajuanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePengajuanMouseClicked
        // TODO add your handling code here:

        
    }//GEN-LAST:event_tablePengajuanMouseClicked

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        int baris = tablePengajuan.getSelectedRow();
        if (baris == -1) {
            JOptionPane.showMessageDialog(this, "Tidak ada data pengajuan yang dipilih","PERINGATAN",JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        nim = tablePengajuan.getValueAt(baris, 1).toString();
        FormApproval formApproval = new FormApproval(this, true, nim);
        formApproval.setLocationRelativeTo(this);
        formApproval.setVisible(true);
        
        tampilDataPengajuan();  
                totalDiproses();
        
    }//GEN-LAST:event_btnEditActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                ListPengajuanSemua dialog = new ListPengajuanSemua(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablePengajuan;
    // End of variables declaration//GEN-END:variables
}
