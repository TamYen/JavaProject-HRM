/*
Created		02/01/2019
Modified		02/01/2019
Project		
Model			
Company		
Author		
Version		
Database		PostgreSQL 8.1 
*/


/* Drop Tables */
Drop table "nghenghiep" Restrict;
Drop table "xeploai" Restrict;
Drop table "chuyennganh" Restrict;
Drop table "khoa_daotao" Restrict;
Drop table "truong_daotao" Restrict;
Drop table "trinhdo_daotao" Restrict;
Drop table "quocgia" Restrict;
Drop table "tongiao" Restrict;
Drop table "dantoc" Restrict;
Drop table "thanhphan_giadinh" Restrict;
Drop table "Tinhthanh" Restrict;
Drop table "Employee" Restrict;


/* Create Domains */


/* Create Tables */


Create table "employee"
(
	"maNV" Varchar NOT NULL,
	"ma_dantoc" Integer,
	"ma_tongiao" Integer,
	"ma_nganh" Integer,
	"ma_loai" Integer,
	"ma_nghe" Integer,
	"id_tp" Integer,
	"quoctich" Integer,
	"noicap_cmnd" Integer,
	"noicap_hochieu" Integer,
	"noisinh" Integer,
	"nguyenquan" Integer,
	"ma_chamcong" Varchar NOT NULL UNIQUE,
	"ten_ho_dem" Varchar,
	"ten" Varchar,
	"ngay_sinh" Date,
	"sex" Bit(1),
	"cmnd" Char(20) UNIQUE,
	"cmnd_ngaycap" Date,
	"Sohochieu" Char(20) UNIQUE,
	"ngaycap_hochieu" Date,
	"hethan_hochieu" Date,
	"trinhdovanhoa" Varchar,
	"namtotnghiep" Integer,
 primary key ("MaNV")
) Without Oids;


Create table "Tinhthanh"
(
	"Ma_tinhthanh" Integer NOT NULL,
	"tentinhthanh" Varchar,
 primary key ("Ma_tinhthanh")
) Without Oids;


Create table "thanhphan_giadinh"
(
	"id_tp" Integer NOT NULL,
	"ten_thanhphan" Varchar,
 primary key ("id_tp")
) Without Oids;


Create table "dantoc"
(
	"ma_dantoc" Integer NOT NULL,
	"dantoc" Varchar,
 primary key ("ma_dantoc")
) Without Oids;


Create table "tongiao"
(
	"ma_tongiao" Integer NOT NULL,
	"ten_tongiao" Varchar,
 primary key ("ma_tongiao")
) Without Oids;


Create table "quocgia"
(
	"ma_quocgia" Integer NOT NULL,
	"ten_quocgia" Varchar,
 primary key ("ma_quocgia")
) Without Oids;


Create table "trinhdo_daotao"
(
	"ma_trinhdo" Integer NOT NULL,
	"trinhdo" Varchar,
 primary key ("ma_trinhdo")
) Without Oids;


Create table "truong_daotao"
(
	"id_daotao" Integer NOT NULL,
	"ten_daotao" Varchar,
 primary key ("id_daotao")
) Without Oids;


Create table "khoa_daotao"
(
	"ma_khoa" Integer NOT NULL,
	"ten_khoa" Varchar,
	"id_daotao" Integer NOT NULL,
 primary key ("ma_khoa")
) Without Oids;


Create table "chuyennganh"
(
	"ma_nganh" Integer NOT NULL,
	"ma_khoa" Integer NOT NULL,
	"ma_trinhdo" Integer NOT NULL,
	"tennganh" Varchar,
 primary key ("ma_nganh")
) Without Oids;


Create table "xeploai"
(
	"ma_loai" Integer NOT NULL,
	"tenloai" Varchar,
 primary key ("ma_loai")
) Without Oids;


Create table "nghenghiep"
(
	"ma_nghe" Integer NOT NULL,
	"tennghe" Varchar,
 primary key ("ma_nghe")
) Without Oids;


/* Create Tab 'Others' for Selected Tables */


