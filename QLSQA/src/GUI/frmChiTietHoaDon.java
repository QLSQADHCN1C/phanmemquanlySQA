/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.ConnectCTHD;
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
public class frmChiTietHoaDon extends javax.swing.JFrame {
    //khai báo một đối tượng của class dbconnect để gọi các hàm thực hiện
    ConnectCTHD con;
    
    private int flag = 0;
    private int selectedRow;
    private ConnectCTHD connectCTHD;
    private Object pt;
    /**
     * Creates new form frmChiTietHoaDon
     */
    public frmChiTietHoaDon() {
        initComponents();
        //khởi tạo đối tượng con
        con = new ConnectCTHD();
        showData();
    }
    //viet ham xoa text
    public void ClearText(){
        txtSHD.setText("");
        txtMaHH.setText("");
        txtTenHH.setText("");
        txtDonGia.setText("");
        txtSoLuong.setText("");
        txtThanhTien.setText("");
        
    }
    //lấy dữ liệu vào table
    public void showData(){
        String[] columnNames = {"SOHD","MAHH","TENHH","DONGIA","SOLUONG","THANHTIEN"};
        //đối tượng này để chứa dữ liệu đổ từ sql để cho vào jTable
        DefaultTableModel model = new DefaultTableModel();
        
        model.setColumnIdentifiers(columnNames);
        
        tblCTHD.setModel(model);
        
        String SOHD = "";
        String MAHH = "";
        String TENHH = "";
        String DONGIA = "";
        String SOLUONG = "";
        String THANHTIEN = "";
        
        ResultSet rs = con.getData("SELECT * FROM CHITIETHOADON");
        try {
            while (rs.next()) {
                SOHD = rs.getString("SOHD");
                MAHH = rs.getString("MAHH");
                TENHH = rs.getString("TENHH");
                DONGIA = rs.getString("DONGIA");
                SOLUONG = rs.getString("SOLUONG");
                THANHTIEN = rs.getString("THANHTIEN");
                
                model.addRow(new Object[]{SOHD,MAHH,TENHH,DONGIA,SOLUONG,THANHTIEN});
            }
        } catch (SQLException ex) {
            Logger.getLogger(frmChiTietHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }        
    //thực hiện Insert
    public void InsertData(){
        String []stringsSQL = {txtSHD.getText().toString(),txtMaHH.getText(),txtTenHH.getText(),txtDonGia.getText(),txtSoLuong.getText(),txtThanhTien.getText()};
        
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
        String []stringsSQL = {txtMaHH.getText(),txtTenHH.getText(),txtDonGia.getText(),txtSoLuong.getText(),txtThanhTien.getText(),txtSHD.getText().toString()};
        
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
        String []stringsSQL = {txtSHD.getText().toString()};
        
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
        int selecttedRow = tblCTHD.getSelectedRow();
        
        txtSHD.setText(tblCTHD.getValueAt(selectedRow,0).toString());
        txtMaHH.setText(tblCTHD.getValueAt(selectedRow,1).toString());
        txtTenHH.setText(tblCTHD.getValueAt(selectedRow,2).toString());
        txtDonGia.setText(tblCTHD.getValueAt(selectedRow,3).toString());
        txtSoLuong.setText(tblCTHD.getValueAt(selectedRow,4).toString());
        txtThanhTien.setText(tblCTHD.getValueAt(selectedRow,5).toString());
    }
    // thuc hien nut previous
    public void getSelectPrevious(){
        if(tblCTHD.getSelectedRow()>= 1){
            int selectedRow = tblCTHD.getSelectedRow()-1;
            txtSHD.setText(tblCTHD.getValueAt(selectedRow,0).toString());
            txtMaHH.setText(tblCTHD.getValueAt(selectedRow,1).toString());
            txtTenHH.setText(tblCTHD.getValueAt(selectedRow,2).toString());
            txtDonGia.setText(tblCTHD.getValueAt(selectedRow,3).toString());
            txtSoLuong.setText(tblCTHD.getValueAt(selectedRow,4).toString());
            txtThanhTien.setText(tblCTHD.getValueAt(selectedRow,5).toString());
            tblCTHD.setRowSelectionInterval(selectedRow,selectedRow);
        }
    }
    // thuc hien nut next
    public void getSelectNext(){
        if(tblCTHD.getSelectedRow() < tblCTHD.getRowCount()-1){
            int selectedRow = tblCTHD.getSelectedRow()+1;
            txtSHD.setText(tblCTHD.getValueAt(selectedRow,0).toString());
            txtMaHH.setText(tblCTHD.getValueAt(selectedRow,1).toString());
            txtTenHH.setText(tblCTHD.getValueAt(selectedRow,2).toString());
            txtDonGia.setText(tblCTHD.getValueAt(selectedRow,3).toString());
            txtSoLuong.setText(tblCTHD.getValueAt(selectedRow,4).toString());
            txtThanhTien.setText(tblCTHD.getValueAt(selectedRow,5).toString());
            tblCTHD.setRowSelectionInterval(selectedRow,selectedRow);
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

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtSHD = new javax.swing.JTextField();
        txtMaHH = new javax.swing.JTextField();
        txtTenHH = new javax.swing.JTextField();
        txtDonGia = new javax.swing.JTextField();
        txtThanhTien = new javax.swing.JTextField();
        txtSoLuong = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCTHD = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnPrerious = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnInsert = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnHome = new javax.swing.JButton();
        btnCalculate = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hóa Đơn Bán Hàng");

        jLabel2.setText("Số Hóa Đơn");

        jLabel3.setText("Mã Hàng Hóa");

        jLabel4.setText("Tên Hàng Hóa");

        jLabel5.setText("Đơn Giá");

        jLabel6.setText("Số Lượng");

        jLabel7.setText("Thành Tiền");

        txtThanhTien.setEditable(false);

        tblCTHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Số Hóa Đơn", "Mã Hóa Đơn", "Tên Hàng Hóa", "Đơn Giá", "Số Lượng", "Thành Tiền"
            }
        ));
        tblCTHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCTHDMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCTHD);

        jLabel1.setFont(new java.awt.Font("Tahoma", 2, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("Chi Tiết Hóa Đơn");

        btnPrerious.setText("Prerious");
        btnPrerious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreriousActionPerformed(evt);
            }
        });

        btnNext.setText("Next");
        btnNext.setPreferredSize(new java.awt.Dimension(71, 23));
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.setPreferredSize(new java.awt.Dimension(71, 23));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnInsert.setText("Insert");
        btnInsert.setPreferredSize(new java.awt.Dimension(71, 23));
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.setPreferredSize(new java.awt.Dimension(71, 23));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.setPreferredSize(new java.awt.Dimension(71, 23));
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

        btnCalculate.setText("Calculate");
        btnCalculate.setPreferredSize(new java.awt.Dimension(71, 23));
        btnCalculate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalculateActionPerformed(evt);
            }
        });

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnPrerious)
                        .addGap(18, 18, 18)
                        .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCalculate, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(274, 274, 274))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSHD, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaHH, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenHH, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(btnHome))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtSHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtMaHH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtTenHH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPrerious)
                    .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCalculate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        // TODO add your handling code here:
        frmTrangChu jfmL = new frmTrangChu();
                    this.setVisible(false);
                    jfmL.setVisible(true);
    }//GEN-LAST:event_btnHomeActionPerformed

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

    private void btnCalculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalculateActionPerformed
        // TODO add your handling code here:
        int DonGia= Integer.parseInt(txtDonGia.getText());
        int SoLuong= Integer.parseInt(txtSoLuong.getText());
        int Tong=DonGia*SoLuong;
        txtThanhTien.setText(Tong+"");
    }//GEN-LAST:event_btnCalculateActionPerformed

    private void tblCTHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCTHDMouseClicked
        // TODO add your handling code here:
        getSelectedData();
    }//GEN-LAST:event_tblCTHDMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        frmHoaDon jfmL = new frmHoaDon();
                    this.setVisible(false);
                    jfmL.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(frmChiTietHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmChiTietHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmChiTietHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmChiTietHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmChiTietHoaDon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalculate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrerious;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCTHD;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtMaHH;
    private javax.swing.JTextField txtSHD;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenHH;
    private javax.swing.JTextField txtThanhTien;
    // End of variables declaration//GEN-END:variables
}
