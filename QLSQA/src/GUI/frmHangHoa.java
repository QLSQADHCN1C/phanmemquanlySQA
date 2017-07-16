/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static GUI.jfmLogin.tenDN;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import BLL.DbConnect;

/**
 *
 * @author hoangdung
 */
public class frmHangHoa extends javax.swing.JFrame {
    //khai báo một đối tượng của class dbconnect để gọi các hàm thực hiện
    DbConnect con;
    
    private int flag = 0;
    private int selectedRow;
    private DbConnect DbConnect;
    private Object pt;
    /**
     * Creates new form frmHangHoa
     */
    public frmHangHoa() {
        initComponents();
        //khởi tạo đối tượng con
        con = new DbConnect();
        showData();
    }
    //viet ham xoa text
    public void ClearText(){
        txtMaHangHoa.setText("");
        txtTenHangHoa.setText("");
        txtGiaBan.setText("");
        cbĐonViTinh.setSelectedIndex(0);
        txtMaNCC.setText("");
        
    }
    //lấy dữ liệu vào table
    public void showData(){
        String[] columnNames = {"MAHH","TENHH","GIABAN","DONVITINH","MANCC"};
        //đối tượng này để chứa dữ liệu đổ từ sql để cho vào jTable
        DefaultTableModel model = new DefaultTableModel();
        
        model.setColumnIdentifiers(columnNames);
        
        tblHangHoa.setModel(model);
        
        String MAHH = "";
        String TENHH = "";
        String GIABAN = "";
        String DONVITINH = "";
        String MANCC = "";
        
        ResultSet rs = con.getData("SELECT * FROM HANGHOA");
        try {
            while (rs.next()) {
                MAHH = rs.getString("MAHH");
                TENHH = rs.getString("TENHH");
                GIABAN = rs.getString("GIABAN");
                DONVITINH = rs.getString("DONVITINH");
                MANCC = rs.getString("MANCC");
                
                model.addRow(new Object[]{MAHH,TENHH,GIABAN,DONVITINH,MANCC});
            }
        } catch (SQLException ex) {
            Logger.getLogger(frmHangHoa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }        
    //thực hiện Insert
    public void InsertData(){
        String DONVITINH = "";
        
        DONVITINH = cbĐonViTinh.getSelectedItem().toString();
        
        String []stringsSQL = {txtMaHangHoa.getText().toString(),txtTenHangHoa.getText(),txtGiaBan.getText(),DONVITINH,txtMaNCC.getText()};
        
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
        String DONVITINH = "";
        
        DONVITINH = cbĐonViTinh.getSelectedItem().toString();
        
        String []stringsSQL = {txtTenHangHoa.getText(),txtGiaBan.getText(),DONVITINH,txtMaNCC.getText(),txtMaHangHoa.getText().toString()};
        
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
        String []stringsSQL = {txtMaHangHoa.getText().toString()};
        
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
        int selecttedRow = tblHangHoa.getSelectedRow();
        
        txtMaHangHoa.setText(tblHangHoa.getValueAt(selectedRow,0).toString());
        txtTenHangHoa.setText(tblHangHoa.getValueAt(selectedRow,1).toString());
        txtGiaBan.setText(tblHangHoa.getValueAt(selectedRow,2).toString());
        cbĐonViTinh.setSelectedItem(tblHangHoa.getValueAt(selectedRow, 3));
        txtMaNCC.setText(tblHangHoa.getValueAt(selectedRow,4).toString());
    }
    // thuc hien nut First
    public void getSelectFirst(){
        int selectedRow = 0;
        txtMaHangHoa.setText(tblHangHoa.getValueAt(selectedRow,0).toString());
        txtTenHangHoa.setText(tblHangHoa.getValueAt(selectedRow,1).toString());
        txtGiaBan.setText(tblHangHoa.getValueAt(selectedRow,2).toString());
        cbĐonViTinh.setSelectedItem(tblHangHoa.getValueAt(selectedRow,3).toString());
        txtMaNCC.setText(tblHangHoa.getValueAt(selectedRow,4).toString());
        tblHangHoa.setRowSelectionInterval(0,0);
    }
    // thuc hien nut previous
    public void getSelectPrevious(){
        if(tblHangHoa.getSelectedRow()>= 1){
            int selectedRow = tblHangHoa.getSelectedRow()-1;
            txtMaHangHoa.setText(tblHangHoa.getValueAt(selectedRow,0).toString());
            txtTenHangHoa.setText(tblHangHoa.getValueAt(selectedRow,1).toString());
            txtGiaBan.setText(tblHangHoa.getValueAt(selectedRow,2).toString());
            cbĐonViTinh.setSelectedItem(tblHangHoa.getValueAt(selectedRow,3).toString());
            txtMaNCC.setText(tblHangHoa.getValueAt(selectedRow,4).toString());
            tblHangHoa.setRowSelectionInterval(selectedRow,selectedRow);
        }
    }
    // thuc hien nut next
    public void getSelectNext(){
        if(tblHangHoa.getSelectedRow() < tblHangHoa.getRowCount()-1){
            int selectedRow = tblHangHoa.getSelectedRow()+1;
            txtMaHangHoa.setText(tblHangHoa.getValueAt(selectedRow,0).toString());
            txtTenHangHoa.setText(tblHangHoa.getValueAt(selectedRow,1).toString());
            txtGiaBan.setText(tblHangHoa.getValueAt(selectedRow,2).toString());
            cbĐonViTinh.setSelectedItem(tblHangHoa.getValueAt(selectedRow,3).toString());
            txtMaNCC.setText(tblHangHoa.getValueAt(selectedRow,4).toString());
            tblHangHoa.setRowSelectionInterval(selectedRow,selectedRow);
        }
        
    }
    // thuc hien nut Last\
    public void getSelectLast(){
        int selectedRow = tblHangHoa.getRowCount()-1;
        txtMaHangHoa.setText(tblHangHoa.getValueAt(selectedRow,0).toString());
        txtTenHangHoa.setText(tblHangHoa.getValueAt(selectedRow,1).toString());
        txtGiaBan.setText(tblHangHoa.getValueAt(selectedRow,2).toString());
        cbĐonViTinh.setSelectedItem(tblHangHoa.getValueAt(selectedRow,3).toString());
        txtMaNCC.setText(tblHangHoa.getValueAt(selectedRow,4).toString());
        tblHangHoa.setRowSelectionInterval(selectedRow,selectedRow);
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtMaHangHoa = new javax.swing.JTextField();
        txtTenHangHoa = new javax.swing.JTextField();
        txtGiaBan = new javax.swing.JTextField();
        txtMaNCC = new javax.swing.JTextField();
        cbĐonViTinh = new javax.swing.JComboBox<>();
        btnInsert = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnQuit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHangHoa = new javax.swing.JTable();
        btnPrerious = new javax.swing.JButton();
        btnFirst = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản Lý Quần Áo");

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 0));
        jLabel1.setText("Quản Lý Quần Áo");

        jLabel2.setText("Mã Hàng Hóa");

        jLabel3.setText("Tên Hàng Hóa");

        jLabel4.setText("Giá Bán");

        jLabel5.setText("Đơn Vị Tính");

        jLabel6.setText("Mã NCC");

        txtMaHangHoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaHangHoaActionPerformed(evt);
            }
        });

        txtTenHangHoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTenHangHoaMouseClicked(evt);
            }
        });

        txtGiaBan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtGiaBanMouseClicked(evt);
            }
        });

        txtMaNCC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtMaNCCMouseClicked(evt);
            }
        });
        txtMaNCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaNCCActionPerformed(evt);
            }
        });

        cbĐonViTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "VNĐ", "USD", "EUR", "JPY", " " }));
        cbĐonViTinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbĐonViTinhMouseClicked(evt);
            }
        });

        btnInsert.setText("Insert");
        btnInsert.setPreferredSize(new java.awt.Dimension(59, 23));
        btnInsert.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInsertMouseClicked(evt);
            }
        });
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.setPreferredSize(new java.awt.Dimension(59, 23));
        btnUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdateMouseClicked(evt);
            }
        });
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.setPreferredSize(new java.awt.Dimension(59, 23));
        btnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteMouseClicked(evt);
            }
        });
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.setPreferredSize(new java.awt.Dimension(59, 23));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnQuit.setText("Home");
        btnQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitActionPerformed(evt);
            }
        });

        tblHangHoa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
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
                "Mã Hàng Hóa", "Tên Hàng Hóa", "Giá Bán", "Đơn Vị Tính", "Mã NCC"
            }
        ));
        tblHangHoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHangHoaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHangHoa);

        btnPrerious.setText("Prerious");
        btnPrerious.setMaximumSize(new java.awt.Dimension(67, 23));
        btnPrerious.setMinimumSize(new java.awt.Dimension(67, 23));
        btnPrerious.setPreferredSize(new java.awt.Dimension(59, 23));
        btnPrerious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreriousActionPerformed(evt);
            }
        });

        btnFirst.setText("First");
        btnFirst.setMaximumSize(new java.awt.Dimension(67, 23));
        btnFirst.setMinimumSize(new java.awt.Dimension(67, 23));
        btnFirst.setPreferredSize(new java.awt.Dimension(59, 23));
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        btnNext.setText("Next");
        btnNext.setPreferredSize(new java.awt.Dimension(59, 23));
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnLast.setText("Last");
        btnLast.setPreferredSize(new java.awt.Dimension(59, 23));
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 255, 51));
        jLabel7.setText("Hoàng Văn Dũng DHCN1C SQTT");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(btnPrerious, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                                            .addComponent(btnLast, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(btnInsert, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                                            .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnQuit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(8, 8, 8)
                                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTenHangHoa, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMaHangHoa, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMaNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbĐonViTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(111, 111, 111))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaHangHoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTenHangHoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cbĐonViTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtMaNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPrerious, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnQuit)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap(23, Short.MAX_VALUE))
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

    private void btnQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitActionPerformed
        // TODO add your handling code here:
                    frmTrangChu jfmL = new frmTrangChu();
                    this.setVisible(false);
                    jfmL.setVisible(true);
    }//GEN-LAST:event_btnQuitActionPerformed

    private void tblHangHoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHangHoaMouseClicked
        // TODO add your handling code here:
        getSelectedData();
    }//GEN-LAST:event_tblHangHoaMouseClicked

    private void txtMaNCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaNCCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaNCCActionPerformed

    private void btnInsertMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInsertMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnInsertMouseClicked

    private void btnUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdateMouseClicked

    private void btnDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteMouseClicked

    private void txtTenHangHoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTenHangHoaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenHangHoaMouseClicked

    private void txtGiaBanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtGiaBanMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGiaBanMouseClicked

    private void cbĐonViTinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbĐonViTinhMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cbĐonViTinhMouseClicked

    private void txtMaNCCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMaNCCMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaNCCMouseClicked

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        // TODO add your handling code here:
        getSelectFirst();
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnPreriousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreriousActionPerformed
        // TODO add your handling code here:
        getSelectPrevious();
    }//GEN-LAST:event_btnPreriousActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        getSelectNext();
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        // TODO add your handling code here:
        getSelectLast();
    }//GEN-LAST:event_btnLastActionPerformed

    private void txtMaHangHoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaHangHoaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaHangHoaActionPerformed

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
            java.util.logging.Logger.getLogger(frmHangHoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmHangHoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmHangHoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmHangHoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmHangHoa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrerious;
    private javax.swing.JButton btnQuit;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbĐonViTinh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblHangHoa;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtMaHangHoa;
    private javax.swing.JTextField txtMaNCC;
    private javax.swing.JTextField txtTenHangHoa;
    // End of variables declaration//GEN-END:variables

    private void initComponent() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
