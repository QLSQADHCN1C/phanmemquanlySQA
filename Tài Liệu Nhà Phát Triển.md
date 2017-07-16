-Tài liệu hướng dẫn phát triển mẫu của nhóm gồm có nhiều bài viết, nhiều câu hỏi và hướng dẫn.

B1: Tạo 1 project và thiết kế project theo mô hình 3 lớp (BLL,DAL,GUI), có DAL để liên kết với các Bảng trong CSDL
<p><img src="https://scontent.fsgn2-1.fna.fbcdn.net/v/t1.0-9/19990587_683472361864016_9169948813736673057_n.jpg?oh=b89c42ed94e1cc2ae817d69ce14589e7&oe=59C41C98"></p>
B2: Tạo class trong DAL. Trong DAL có các class chứa các chức năng kết nối với csdl
<p><img src="https://scontent.fsgn2-1.fna.fbcdn.net/v/t1.0-9/20108622_683472358530683_6520671058873428397_n.jpg?oh=4ed920706b3a3511793b9c71e01176e2&oe=5A0A56FD"></p>
B3: Tạo class trong BLL để liên kết với các bảng trong csdl
<p><img src="https://scontent.fsgn2-1.fna.fbcdn.net/v/t1.0-9/20031546_683472355197350_6610075986209625925_n.jpg?oh=ca150ad7cb651e66eded3bc9068388b7&oe=59FC6341"></p>
<p><img src=""></p>
B4: Tạo class trong GUI. Trong GUI có các class chứa các chức năng thực thi truy vấn như thêm, sửa, xóa, cập nhật vào csdl.
Ở đây câu lệnh truy vấn được đặt bên DAL và ta chỉ việc gọi lại bên GUI
<p><img src="https://scontent.fsgn2-1.fna.fbcdn.net/v/t1.0-9/20106516_683472385197347_6394497937375280678_n.jpg?oh=689914a801e615e07ba3edf626eb7c53&oe=5A042805"></p>
<p><img src="https://scontent.fsgn2-1.fna.fbcdn.net/v/t1.0-9/19990168_683472381864014_1593295186841316494_n.jpg?oh=59081aa32aae227e1dec63a55131420f&oe=5A109B07"></p>
-Làm thế nào đặt chế độ chỉ đọc khi tích radial button?

-Trả lời: Ta làm như sau:

- Ta viết code trực tiếp cho radial button

     txtNgayHH.ReadOnly = true;
Trong đó: txtNgayHH là textbox mà bạn muốn đặt chế độ chỉ đọc
<p><img src="https://www.facebook.com/photo.php?fbid=683477808530138&set=a.116759741868617.1073741838.100006037742697&type=3&theater"></p>
