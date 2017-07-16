/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import GUI.frmTrangChu;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;

/**
 *
 * @author hoangdung
 */
public class ConnectTT {
    // khai báo một đối tượng để kết nối java với sql
    Connection con;
    
    public ConnectTT(){
        //Khai báo chuối kết nối
        String stringCon="jdbc:sqlserver://DESKTOP-5203ESB:1433;databaseName=QLSQA";
        try {
            con = DriverManager.getConnection(stringCon, "sa", "123456");
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ConnectTT.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(ConnectTT.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    public static void mail(String[] args) {
        frmTrangChu TT=new frmTrangChu();
        TT.setVisible(true);
    }
}
