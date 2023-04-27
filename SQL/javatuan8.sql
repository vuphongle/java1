CREATE DATABASE QUANLYSV

USE QUANLYSV

CREATE TABLE LopHoc
(
	maLop varchar(20) not null primary key,
	tenLop nvarchar(100) not null
)

CREATE TABLE SinhVien
(
	masv char(10) not null primary key,
	ho nvarchar(30),
	ten nvarchar(30) not null,
	phai nvarchar(10),
	email varchar(50),
	diaChi nvarchar(100),
	maLop varchar(20) foreign key references LopHoc(maLop)
)

INSERT LopHoc VALUES('LH01', 'DHKTPM17C'), ('LH02', 'DHKHDL17A')

INSERT SinhVien VALUES('SV01', 'Le', 'Phong', 'Nam', 'abc@gmail.com','Tien Giang', 'LH01'),
('SV02', 'Tran', 'Nhan', 'Nam', 'affdbc@gmail.com','HCM', 'LH02')

SELECT * FROM LopHoc
SELECT * FROM SinhVien

select COUNT(p.masv) as siSo from LopHoc o left join SinhVien p on o.maLop = p.maLop group by o.maLop

insert SinhVien values('SV03', 'Mai', 'Dat', 'Nam', 'SSS@gmail.com', 'Can Tho', 'LH01'), 
('SV04', 'Luu', 'My Phung', 'Nu', 'lhmp@gmail.com', 'Kien Giang', 'LH02'),
('SV05', 'Huynh', 'Vy', 'Nu', 'hvp@gmail.com', 'Ha Noi', 'LH02'),
('SV06', 'Nguyen', 'Dung', 'Nam', 'dmfds@gmail.com', 'TPHCM', 'LH03'),
('SV07', 'Mai', 'Chien No', 'Nam', '323mp@gmail.com', 'Dong Thap', 'LH03'),
('SV08', 'Nhat', 'Duong', 'Nu', 'lh33@gmail.com', 'Long An', 'LH06')

SELECT COUNT(*) AS 'SoLuongSV'
FROM SinhVien
WHERE maLop = 'LH01';