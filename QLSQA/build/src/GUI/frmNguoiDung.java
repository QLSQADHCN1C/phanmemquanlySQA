/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.ConnectNguoiDung;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hoangdung
 */
public class frmNguoiDung extends javax.swing.JFrame {
    ConnectNguoiDung con;
    
    private int flag = 0;
    private int selectedRow;
    private ConnectNguoiDung connectNguoiDung;
    private Object pt;
    /**
     * Creates new form frmNguoiDung
     */
    public frmNguoiDung() {
        initComponents();
        //khởi tạo đối tượng con
        con = new ConnectNguoiDung();
        showData();
    }
    //viet ham xoa text
    public void ClearText(){
        txtMaNV.setText("");
        txtTenNV.setText("");
        txtTK.setText("");
        txtMK.setText("");
        cbChuc.setSelectedIndex(0);
        
    }
    //lấy dữ liệu vào table
    public void showData(){
        String[] columnNames = {"MANV","TENNV","TAIKHOAN","MATKHAU","QUYEN"};
        //đối tượng này để chứa dữ liệu đổ từ sql để cho vào jTable
        DefaultTableModel model = new DefaultTableModel();
        
        model.setColumnIdentifiers(columnNames);
        
        tblQLNV.setModel(model);
        
        String MANV = "";
        String TENNV = "";
        String TAIKHOAN = "";
        String MATKHAU = "";
        String QUYEN = "";
        
        ResultSet rs = con.getData("SELECT * FROM NGUOIDUNG");
        try {
            while (rs.next()) {
                MANV = rs.getString("MANV");
                TENNV = rs.getString("TENNV");
                TAIKHOAN = rs.getString("TAIKHOAN");
                MATKHAU = rs.getString("MATKHAU");
                QUYEN = rs.getString("QUYEN");
                
                model.addRow(new Object[]{MANV,TENNV,TAIKHOAN,MATKHAU,QUYEN});
            }
        } catch (SQLException ex) {
            Logger.getLogger(frmNguoiDung.class.getName()).log(Level.SEVERE, null, ex);
        }
    }        
    //thực hiện Insert
    public void InsertData(){
        String QUYEN = "";
        
        QUYEN = cbChuc.getSelectedItem().toString();
        String []stringsSQL = {txtMaNV.getText().toString(),txtTenNV.getText(),txtTK.getText(),txtMK.getText(),QUYEN};
        
        int isInsert = con.ExcuteSQLInsert(stringsSQL);
        if(isInsert >0 ){
            JOptionPane.showMessageDialog(this, "Them Du Lieu Thanh Cong :)");
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Them Du Lieu Khong Thanh Cong :(");
        }
        
        showData();
        ClearText();
    }
    // thuc hien Update
    public void UpdateData(){
        String QUYEN = "";
        
        QUYEN = cbChuc.getSelectedItem().toString();
        String []stringsSQL = {txtTenNV.getText(),txtTK.getText(),txtMK.getText(),QUYEN,txtMaNV.getText().toString()};
        
        int isUpdate = con.ExcuteSQLUpdate(stringsSQL);
        if(isUpdate >0 ){
            JOptionPane.showMessageDialog(this, "Sua Du Lieu Thanh Cong :)");
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Sua Du Lieu Khong Thanh Cong :(");
        }
        
        showData();
        ClearText();
    }
    //thực hiện delete dư lieu
    public void DeleteData(){
        String []stringsSQL = {txtMaNV.getText().toString()};
        
        int isDelete = con.ExcuteSQLDelete(stringsSQL);
        if(isDelete >0 ){
            JOptionPane.showMessageDialog(this, "Xoa Du Lieu Thanh Cong :)");
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Xoa Du Lieu Khong Thanh Cong :(");
        }
        
        showData();
        ClearText();
    }
    //lay thong tin du lieu duoc chon
    public void getSelectedData(){
        int selecttedRow = tblQLNV.getSelectedRow();
        
        txtMaNV.setText(tblQLNV.getValueAt(selectedRow,0).toString());
        txtTenNV.setText(tblQLNV.getValueAt(selectedRow,1).toString());
        txtTK.setText(tblQLNV.getValueAt(selectedRow,2).toString());
        txtMK.setText(tblQLNV.getValueAt(selectedRow,3).toString());
        cbChuc.setSelectedItem(tblQLNV.getValueAt(selectedRow, 4));
    }
    // thuc hien nut previous
    public void getSelectPrevious(){
        if(tblQLNV.getSelectedRow()>= 1){
            txtMaNV.setText(tblQLNV.getValueAt(selectedRow,0).toString());
            txtTenNV.setText(tblQLNV.getValueAt(selectedRow,1).toString());
            txtTK.setText(tblQLNV.getValueAt(selectedRow,2).toString());
            txtMK.setText(tblQLNV.getValueAt(selectedRow,3).toString());
            cbChuc.setSelectedItem(tblQLNV.getValueAt(selectedRow,4).toString());
            tblQLNV.setRowSelectionInterval(selectedRow,selectedRow);
        }
    }
    // thuc hien nut next
    public void getSelectNext(){
        if(tblQLNV.getSelectedRow() < tblQLNV.getRowCount()-1){
            int selectedRow = tblQLNV.getSelectedRow()+1;
            txtMaNV.setText(tblQLNV.getValueAt(selectedRow,0).toString());
            txtTenNV.setText(tblQLNV.getValueAt(selectedRow,1).toString());
            txtTK.setText(tblQLNV.getValueAt(selectedRow,2).toString());
            txtMK.setText(tblQLNV.getValueAt(selectedRow,3).toString());
            cbChuc.setSelectedItem(tblQLNV.getValueAt(selectedRow,4).toString());
            tblQLNV.setRowSelectionInterval(selectedRow,selectedRow);
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblQLNV = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnPrerious = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnInsert = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        txtMaNV = new javax.swing.JTextField();
        txtTenNV = new javax.swing.JTextField();
        txtTK = new javax.swing.JTextField();
        txtMK = new javax.swing.JTextField();
        cbChuc = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản Lý Nhân Viên");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("Quản Lý Nhân Viên");

        tblQLNV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã Nhân Viên", "Tên Nhân Viên", "Tài Khoản", "Mật Khẩu", "Chức Vụ"
            }
        ));
        tblQLNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblQLNVMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblQLNV);

        jLabel2.setText("Mã Nhân Viên");

        jLabel3.setText("Tên Nhân Viên");

        jLabel4.setText("Tài Khoản");

        jLabel5.setText("Mật Khẩu");

        jLabel6.setText("Chức Vụ");

        btnPrerious.setText("Prerious");
        btnPrerious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreriousActionPerformed(evt);
            }
        });

        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnInsert.setText("Insert");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        jButton7.setText("Home");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        cbChuc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quản Lý", "Thu Ngân", "Tiếp Viên", "Thủ Khố" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(253, 253, 253))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtMK)
                                            .addComponent(txtTK)
                                            .addComponent(txtTenNV)
                                            .addComponent(cbChuc, 0, 100, Short.MAX_VALUE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnPrerious, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnInsert, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                                            .addComponent(btnNext, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbChuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnPrerious)
                            .addComponent(btnNext))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnInsert)
                            .addComponent(btnUpdate))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSave)
                            .addComponent(btnDelete))
                        .addGap(18, 18, 18)
                        .addComponent(jButton7))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        // TODO add your handling code here:
        ClearText();
        btnSave.setEnabled(true);
        flag = 1;
        btnInsert.setEnabled(false);
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);
    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        btnSave.setEnabled(true);
        flag = 2;
        btnInsert.setEnabled(false);
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        btnSave.setEnabled(true);
        flag = 3;
        btnInsert.setEnabled(false);
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        if(flag == 1){
            InsertData();
            btnInsert.setEnabled(true);
            btnUpdate.setEnabled(true);
            btnDelete.setEnabled(true);
        }
        else if(flag ==2)
        {
            UpdateData();
            btnInsert.setEnabled(true);
            btnUpdate.setEnabled(true);
            btnDelete.setEnabled(true);
        }
        else
        {
            DeleteData();
            btnInsert.setEnabled(true);
            btnUpdate.setEnabled(true);
            btnDelete.setEnabled(true);
        }
        ClearText();
        btnSave.setEnabled(false);
    }//GEN-LAST:event_btnSaveActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        frmTrangChu jfmL = new frmTrangChu();
                    this.setVisible(false);
                    jfmL.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void tblQLNVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblQLNVMouseClicked
        // TODO add your handling code here:
        getSelectedData();
    }//GEN-LAST:event_tblQLNVMouseClicked

    private void btnPreriousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreriousActionPerformed
        // TODO add your handling code here:
        getSelectPrevious();
    }//GEN-LAST:event_btnPreriousActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        getSelectNext();
    }//GEN-LAST:event_btnNextActionPerformed

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
            java.util.logging.Logger.getLogger(frmNguoiDung.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmNguoiDung.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmNguoiDung.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmNguoiDung.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmNguoiDung().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrerious;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbChuc;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblQLNV;
    private javax.swing.JTextField txtMK;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtTK;
    private javax.swing.JTextField txtTenNV;
    // End of variables declaration//GEN-END:variables

}
