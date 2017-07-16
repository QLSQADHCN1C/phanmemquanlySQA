/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.sql.*;
import DAL.*;

// Kiểm tra kết nối
public class testConnectBLL {
    public static Connection conn = null;
    public static ResultSet rs = null;
    public static PreparedStatement pst = null;
    public static String testConnectBLL()
    {
        try
        {
            conn = ConnectDAL.getConnect();
            return "Kết nối thành công";
        }
        catch (Exception e)
        {
            return"Kết nối thất bại";
        }
    }
    public static ResultSet resul (String TAIKHOAN, String MATKHAU)
    {
        String sql= "select *from DANGNHAP where TAIKHOAN=? and MATKHAU=?";
        try
        {
            pst = conn.prepareStatement(sql);
            pst.setString(1, TAIKHOAN);
            pst.setString(2, MATKHAU);
            return rs= pst.executeQuery();
        }
        catch(Exception e)
        {
            return rs=null;
        }
    }
}
