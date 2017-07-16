-Tài liệu hướng dẫn phát triển mẫu của nhóm gồm có nhiều bài viết, nhiều câu hỏi và hướng dẫn.

B1: Tạo 1 project và thiết kế project theo mô hình 3 lớp (BLL,DAL,GUI), có DAL để liên kết với các Bảng trong CSDL
<p><img src="https://scontent.fsgn2-1.fna.fbcdn.net/v/t1.0-9/19990587_683472361864016_9169948813736673057_n.jpg?oh=b89c42ed94e1cc2ae817d69ce14589e7&oe=59C41C98"></p>
B2: Tạo class trong BLL để liên kết với các bảng trong csdl
<p><img src="https://scontent.fsgn2-1.fna.fbcdn.net/v/t1.0-9/20108622_683472358530683_6520671058873428397_n.jpg?oh=4ed920706b3a3511793b9c71e01176e2&oe=5A0A56FD"></p>
Tạo class trong DAL. Trong DAL có các class chứa các chức năng kết nối với csdl
<p><img src="https://scontent.fsgn2-1.fna.fbcdn.net/v/t1.0-9/20108622_683472358530683_6520671058873428397_n.jpg?oh=4ed920706b3a3511793b9c71e01176e2&oe=5A0A56FD"></p>
<p><img src=""></p>
B4: Tạo class trong GUI. Trong GUI có các class chứa các chức năng thực thi truy vấn như thêm, sửa, xóa, cập nhật vào csdl.
Ở đây câu lệnh truy vấn được đặt bên DAL và ta chỉ việc gọi lại bên GUI
