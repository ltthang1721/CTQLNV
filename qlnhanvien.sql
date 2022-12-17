drop database qlnhanvien;
create database qlnhanvien character set='utf8';
use qlnhanvien;

create table chucvu(
	machucvu varchar(10) primary key,
    tenchucvu varchar(50),
	luongcoban int
);
create table nhanvien (
    manhanvien varchar(10) primary key, 
    hoten varchar(50),
    gioitinh varchar(10),
    diachi varchar (100),
    SDT varchar(20),
    email varchar (50),
	machucvu char(10),
    foreign key (machucvu) references chucvu(machucvu)
	
);

create table tinhluong(
			manhanvien varchar(10),
			machucvu varchar(10),
			tonggio int,
			primary key (manhanvien, machucvu),
			foreign key (manhanvien) references nhanvien(manhanvien),
			foreign key (machucvu) references chucvu(machucvu)
			);

insert into chucvu values ('ql', 'Quản lý','35000');
insert into chucvu values ('pv', 'Phục vụ','25000');
insert into chucvu values ('pc', 'Pha chế','30000');
insert into chucvu values ('tn', 'Thu ngân','20000');
insert into chucvu values ('bv', 'Bảo Vệ','15000');
select *from qlnhanvien.chucvu;

insert into nhanvien values ('NV01', 'Nguyễn Thị Trang Đài','Nữ','Hẻm 520 đường 30/4, Hưng Lợi','0338014027','daib1910049@student.ctu.edu.vn','ql');
insert into nhanvien values ('NV02', 'Mai Nhựt Long','Nam','Hẻm 51 đường 3/2, An Khánh','0332002059','longb1910095@student.ctu.edu.vn','bv');
insert into nhanvien values ('NV03', 'Lê Nhựt Linh','Nam','Cầu Bà Bộ đường Nguyễn Văn Linh, Long Tuyền','0834462146','linhb1910092@student.ctu.edu.vn','pv');
insert into nhanvien values ('NV04', 'Phan Minh Hiền','Nam','Hẻm 98 đường Trần Hưng Đạo, An Nghiệp','0329329574','hienb1909916@student.ctu.edu.vn', 'pv');
insert into nhanvien values ('NV05', 'Nguyễn Võ Việt Nga','Nữ','Kí Túc Xá B Khu 2 ĐHCT đường 3/2, Xuân Khánh','0852525269','ngab1909953@student.ctu.edu.vn', 'tn');
insert into nhanvien values ('NV06', 'Đặng Thị Khánh Băng','Nữ','Hẻm 117 đường 3/2, An Khánh','0898025704','bangb1909963@student.ctu.edu.vn', 'tn');
insert into nhanvien values ('NV07', 'Cao Văn Danh','Nam','Hẻm 520 đường 30/4, Hưng Lợi','0328292987','danhb1910041@student.ctu.edu.vn', 'pc');
insert into nhanvien values ('NV08', 'Lê Thị Thúy Hằng','Nữ','Kí Túc Xá B Khu 2 ĐHCT đường 3/2, Xuân Khánh','0398587715','hangb1910067@student.ctu.edu.vn', 'pc');
select *from qlnhanvien.nhanvien;

insert into tinhluong values ('NV01','ql','10');
insert into tinhluong values ('NV02','bv','12');
insert into tinhluong values ('NV03','pv','9');
insert into tinhluong values ('NV04','pv','8');
insert into tinhluong values ('NV05','tn','7');
insert into tinhluong values ('NV06','tn','6');
insert into tinhluong values ('NV07','pc','9');
insert into tinhluong values ('NV08','pc','10');
select *from qlnhanvien.tinhluong;
