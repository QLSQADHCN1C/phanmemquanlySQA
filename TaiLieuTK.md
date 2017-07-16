## Qui trình tiếp nhận và quản lí

# Sơ Bộ  

  -Nhập Hàng Hóa Từ Nhà Cung Cấp để cho vào danh sách hàng .Phân Loại và định giá sản phẩm
  -Tiếp Nhận Và Quản lý nhân viên theo mã và cấp quyền cho nhân viên. khi cấp quyền xong nhân viên không thể sử dụng quá quyền hạn của mình
  -Hàng Hóa được khách mua sẽ thanh toán thông qua nhân viên bàng hóa đơn bán hàng
  -Hàng tháng quản lý se làm việc với nhân viên để dựa vào số ngày lương để tính lương tuy theo chức vụ trong cửa hàng

# Sơ Đồ Phân Rã Chức Năng(BFD)
<p><img src="https://scontent.fdad3-2.fna.fbcdn.net/v/t1.0-9/19990068_683567908521128_7397526770425143926_n.jpg?oh=5fba0bbc5f8f2f5ae8ede6f1b1c19326&oe=5A0D6471"></p>

# Sơ đồ luồng dữ liệu(DFD)

DFD Quản Lý Nhân Viên
<p><img src="https://scontent.fdad3-2.fna.fbcdn.net/v/t1.0-9/20108376_683567915187794_5983344337882194272_n.jpg?oh=d2aa480577768977acf1c0b7c371458a&oe=59CA6B01"></p>
DFD Quản Lý Nhập Xuất
<p><img src="https://scontent.fdad3-2.fna.fbcdn.net/v/t1.0-9/20108686_683567911854461_2047123958839529568_n.jpg?oh=4ea767c7bd7f662bdd395254684051e1&oe=59F74823"></p>
DFD Quản Lý Bán Hàng
<p><img src="https://scontent.fdad3-2.fna.fbcdn.net/v/t1.0-9/19961471_683567935187792_1380802811339806226_n.jpg?oh=61185750c4d8351ba2e0aa6c33aa1069&oe=59FC4572"></p>

# Sơ Đồ QUan Hệ (ERD)

<p><img src="https://scontent.fdad3-2.fna.fbcdn.net/v/t1.0-9/20046745_683568151854437_3064097255819439932_n.jpg?oh=54861c432feb8cac5d0e686b1a493d26&oe=59FBA51F"></p>

# Code xây dựng CSDL

CREATE DATABASE QLSQA;

use QLSQA

go

create table DANGNHAP (

TenDN	nvarchar(20) not null,
MK		nvarchar(20) not null,
constraint pk5 primary key (TenDN,MK)

)

create table HANGHOA (

MAHH nvarchar(10) not null FOREIGN KEY  ,
TENHH nvarchar(30) not null,
GIABAN nvarchar(30) not null,
DONVITINH nvarchar(30) not null,
MANCC nvarchar(30) not null,
)

create table HOADON (

SOHD nvarchar(7) primary key not null,

NGAYLAP date not null,

MANV nvarchar(10) not null,

TENKH nvarchar(30) not null,

TONG int not null,
)

create table CHITIETHOADON (

SOHD nvarchar(7) FOREIGN KEY, 

MAHH nvarchar(30) not null,

TENHH nvarchar(30) not null ,

DONGIA int,

SOLUONG int,

THANHTIEN int,
)

create table NGUOIDUNG (

MANV nvarchar(30) not null primary key,

TAIKHOAN nvarchar (30) not null,

MATKHAU nvarchar (30) not null;
QUYEN nvarchar (30) not null;
)
create table NHACUNGCAP (

MANCC nvarchar(30) not null primary key,

TENNCC nvarchar (30) not null,

DIACHI nvarchar (30) not null;

DIENTHOAI nvarchar (30) not null;

WEBSITE nvarchar (30) not null;
)

