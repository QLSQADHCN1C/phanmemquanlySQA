/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;

/**
 *
 * @author hoangdung
 */
public class ConnectHoaDon {
    // khai báo một đối tượng để kết nối java với sql
    Connection con;
    
    public ConnectHoaDon(){
        //Khai báo chuối kết nối
        String stringCon="jdbc:sqlserver://DESKTOP-5203ESB:1433;databaseName=QLSQA";
        try {
            con = DriverManager.getConnection(stringCon, "sa", "123456");
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ConnectHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //viết hàm lấy dữ liệu từ bảng database
    public ResultSet getData(String stringSQL){
       //đối tượng này sẽ chứa kết quả trả về từ sql
        ResultSet rs=null;
        try {
            // đói tuowjgn này tạo đường dẫn kết nối tới SQl
            Statement state = con.createStatement();
            rs = state.executeQuery(stringSQL);
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ConnectHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    //viết hàm thực hiện lệnh insert
    public int ExcuteSQLInsert(String[] stringsSQL){
        int rowsInserted =0;
        String sql ="INSERT INTO HOADON(SOHD,NGAYLAP,MANV,TENKH,TONG) VALUES(?,?,?,?,?)";
        //Đối tượng này giống statemen
        PreparedStatement statement;
        try {
            statement = con.prepareStatement(sql);
            statement.setString(1, stringsSQL[0]);
            statement.setString(2, stringsSQL[1]);
            statement.setString(3, stringsSQL[2]);
            statement.setString(4, stringsSQL[3]);
            statement.setString(5, stringsSQL[4]);
            
            rowsInserted = statement.executeUpdate();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ConnectHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rowsInserted;
    }
    // viet ham update
    public int ExcuteSQLUpdate(String[] stringsSQL){
        int rowsInserted =0;
        String sql ="UPDATE HOADON SET NGAYLAP=?,MANV=?,TENKH=?,TONG=? WHERE SOHD=?";
        //Đối tượng này giống statemen
        PreparedStatement statement;
        try {
            statement = con.prepareStatement(sql);
            statement.setString(1, stringsSQL[0]);
            statement.setString(2, stringsSQL[1]);
            statement.setString(3, stringsSQL[2]);
            statement.setString(4, stringsSQL[3]);
            statement.setString(5, stringsSQL[4]);
            
            rowsInserted = statement.executeUpdate();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ConnectHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rowsInserted;
    }
    // viet ham Delete
    public int ExcuteSQLDelete(String[] stringsSQL){
        int rowsInserted =0;
        String sql ="DELETE FROM HOADON WHERE SOHD=?";
        //Đối tượng này giống statemen
        PreparedStatement statement;
        try {
            statement = con.prepareStatement(sql);
            statement.setString(1, stringsSQL[0]); 
            rowsInserted = statement.executeUpdate();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ConnectHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rowsInserted;
    }
}
