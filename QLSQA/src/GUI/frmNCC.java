/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.ConnectNCC;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hoangdung
 */
public class frmNCC extends javax.swing.JFrame {
    //khai báo một đối tượng của class dbconnect để gọi các hàm thực hiện
    ConnectNCC con;
    
    private int flag = 0;
    private int selectedRow;
    private ConnectNCC connectNCC;
    private Object pt;

    /**
     * Creates new form frmNCC
     */
    public frmNCC() {
        initComponents();
        //khởi tạo đối tượng con
        con = new ConnectNCC();
        showData();
    }
    //viet ham xoa text
    public void ClearText(){
        txtMaNCC.setText("");
        txtTenNCC.setText("");
        txtDiaCHi.setText("");
        txtSDT.setText("");
        txtWEB.setText("");
        
    }
    //lấy dữ liệu vào table
    public void showData(){
        String[] columnNames = {"MANCC","TENNCC","DIACHI","DIENTHOAI","WEBSITE"};
        //đối tượng này để chứa dữ liệu đổ từ sql để cho vào jTable
        DefaultTableModel model = new DefaultTableModel();
        
        model.setColumnIdentifiers(columnNames);
        
        tblNCC.setModel(model);
        
        String MANCC = "";
        String TENNCC = "";
        String DIACHI = "";
        String DIENTHOAI = "";
        String WEBSITE = "";
        
        ResultSet rs = con.getData("SELECT * FROM NHACUNGCAP");
        try {
            while (rs.next()) {
                MANCC = rs.getString("MANCC");
                TENNCC = rs.getString("TENNCC");
                DIACHI = rs.getString("DIACHI");
                DIENTHOAI = rs.getString("DIENTHOAI");
                WEBSITE = rs.getString("WEBSITE");
                
                model.addRow(new Object[]{MANCC,TENNCC,DIACHI,DIENTHOAI,WEBSITE});
            }
        } catch (SQLException ex) {
            Logger.getLogger(frmHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }        
    //thực hiện Insert
    public void InsertData(){
        String []stringsSQL = {txtMaNCC.getText().toString(),txtTenNCC.getText(),txtDiaCHi.getText(),txtSDT.getText(),txtWEB.getText()};
        
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
        String []stringsSQL = {txtTenNCC.getText(),txtDiaCHi.getText(),txtSDT.getText(),txtWEB.getText(),txtMaNCC.getText().toString()};
        
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
        String []stringsSQL = {txtMaNCC.getText().toString()};
        
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
        int selecttedRow = tblNCC.getSelectedRow();
        
        txtMaNCC.setText(tblNCC.getValueAt(selectedRow,0).toString());
        txtTenNCC.setText(tblNCC.getValueAt(selectedRow,1).toString());
        txtDiaCHi.setText(tblNCC.getValueAt(selectedRow,2).toString());
        txtSDT.setText(tblNCC.getValueAt(selectedRow,3).toString());
        txtWEB.setText(tblNCC.getValueAt(selectedRow,4).toString());
    }
    // thuc hien nut previous
    public void getSelectPrevious(){
        if(tblNCC.getSelectedRow()>= 1){
            int selectedRow = tblNCC.getSelectedRow()-1;
            txtMaNCC.setText(tblNCC.getValueAt(selectedRow,0).toString());
            txtTenNCC.setText(tblNCC.getValueAt(selectedRow,1).toString());
            txtDiaCHi.setText(tblNCC.getValueAt(selectedRow,2).toString());
            txtSDT.setText(tblNCC.getValueAt(selectedRow,3).toString());
            txtWEB.setText(tblNCC.getValueAt(selectedRow,4).toString());
            tblNCC.setRowSelectionInterval(selectedRow,selectedRow);
        }
    }
    // thuc hien nut next
    public void getSelectNext(){
        if(tblNCC.getSelectedRow() < tblNCC.getRowCount()-1){
            int selectedRow = tblNCC.getSelectedRow()+1;
            txtMaNCC.setText(tblNCC.getValueAt(selectedRow,0).toString());
            txtTenNCC.setText(tblNCC.getValueAt(selectedRow,1).toString());
            txtDiaCHi.setText(tblNCC.getValueAt(selectedRow,2).toString());
            txtSDT.setText(tblNCC.getValueAt(selectedRow,3).toString());
            txtWEB.setText(tblNCC.getValueAt(selectedRow,4).toString());
            tblNCC.setRowSelectionInterval(selectedRow,selectedRow);
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
        tblNCC = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnPrerious = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnInsert = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnHome = new javax.swing.JButton();
        txtMaNCC = new javax.swing.JTextField();
        txtTenNCC = new javax.swing.JTextField();
        txtDiaCHi = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        txtWEB = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản Lý Nhà Cung Cấp");

        tblNCC.setModel(new javax.swing.table.DefaultTableModel(
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
                "Mã Nhà Cung Cấp", "Tên Nhà Cung Cấp", "Địa Chỉ", "Điện Thoại", "Website"
            }
        ));
        tblNCC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNCCMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblNCC);

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("Nhà Cung Cấp");

        jLabel2.setText("Mã NCC");

        jLabel3.setText("Tên NCC");

        jLabel4.setText("Địa Chỉ");

        jLabel5.setText("Điện Thoại");

        jLabel6.setText("Website");

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

        btnInsert.setText("Insert");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
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

        btnHome.setText("Home");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(273, 273, 273))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnPrerious)
                            .addComponent(btnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnNext, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtMaNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtTenNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtWEB, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtDiaCHi, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(btnHome)))
                        .addGap(0, 7, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtMaNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtTenNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtDiaCHi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtWEB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnPrerious)
                            .addComponent(btnNext))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnInsert)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDelete)
                            .addComponent(btnSave))
                        .addGap(18, 18, 18)
                        .addComponent(btnHome)
                        .addGap(22, 22, 22))))
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

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        getSelectNext();
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnPreriousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreriousActionPerformed
        // TODO add your handling code here:
        getSelectPrevious();
    }//GEN-LAST:event_btnPreriousActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        // TODO add your handling code here:
        frmTrangChu jfmL = new frmTrangChu();
                    this.setVisible(false);
                    jfmL.setVisible(true);
    }//GEN-LAST:event_btnHomeActionPerformed

    private void tblNCCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNCCMouseClicked
        // TODO add your handling code here:
        getSelectedData();
    }//GEN-LAST:event_tblNCCMouseClicked

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
            java.util.logging.Logger.getLogger(frmNCC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmNCC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmNCC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmNCC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmNCC().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrerious;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblNCC;
    private javax.swing.JTextField txtDiaCHi;
    private javax.swing.JTextField txtMaNCC;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenNCC;
    private javax.swing.JTextField txtWEB;
    // End of variables declaration//GEN-END:variables

}
