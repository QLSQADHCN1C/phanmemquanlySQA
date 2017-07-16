# THÔNG TIN TỔ CHỨC MÃ NGUỒN VÀ CHUẨN LẬP TRÌNH

Để thống nhất và tuân thủ quy tắc đặt tên sẽ giúp dễ dàng quản lý project của mình, tăng khả năng sử dụng lại code, thuận tiện trong việc trao đổi với nhóm, dễ dàng mở rộng nhóm. Cách đặt tên dễ hiểu, dễ nhớ còn giúp bạn “nhẹ đầu” hơn khi phải đọc lại code của chính mình. Thì các thành viên trong nhóm chúng xẽ thống nhất với nhau xẽ làm việc theo chuẩn sau:

+ Tổ chức lập trình: Chúng ta xẽ triển khai dự án theo mô hình 3 lớp.

- Preject DAL: kết nối dữ liệu với Sql

ví dụ :

public class ConnectDAL {
    // kết nối với CSDL
    
    public static Connection getConnect()
    
    {
        try
        
        {
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-5203ESB:1433;databaseName=QLSQA;user=sa;password=123456");
            
            return conn;
            
        }
        catch (Exception e)
        
        {
            JOptionPane.showMessageDialog(null, "kết nối thất bại", "Thông Báo", 1);
            
            return null;
            
        }
    }
    
}



