create database Restaurant;
use Restaurant

-- tạo bảng 
create table category
(
	Category_id nvarchar(50) NOT NULL primary key,
	Category_name nvarchar(50)
);

create table product
(
	Product_id nvarchar(50) NOT NULL primary key,
	image_product nvarchar(MAX),
	Name_product nvarchar(50),
	Category_id nvarchar(50) foreign key references category(Category_id),
	price int,
	DateCreate datetime,
	Stock bit,
	rating float
);

create table roleDetail
(
	RoleID nvarchar(50) NOT NULL primary key,
	Name_Role nvarchar(50),
);

create table account
(
	accID nvarchar(50) NOT NULL primary key,
	Username nvarchar(50),
	Pass nvarchar(50),
	FullName nvarchar(50),
	RoleID nvarchar(50) foreign key references roleDetail(RoleID),
	StatusAcc bit
);

create table [dbo].[OrderDetail]
(
	DOID nvarchar(50) NOT NULL foreign key references [dbo].[Order](OID),
	Product_id nvarchar(50) NOT NULL foreign key references product(Product_id),
	quantity int,
	total float,
	CONSTRAINT PK_OrderDetail PRIMARY KEY (DOID, Product_id) 
);

create table [dbo].[Order]
(
	OID nvarchar(50) NOT NULL,
	accID nvarchar(50) foreign key references account(accID), 
	total float,
	DateOrder datetime,
	CONSTRAINT PK_ORDER PRIMARY KEY (OID) 
);


-- insert dữ liệu vào bảng
-- insert category
insert into category values ('C1', 'Asian Food')
insert into category values('C2', 'Italian Food')
insert into category values('C3', 'Indian Food')


-- insert product
insert into product values ('P0001', 'img/Pho-Beef-Noodles-2008.jpg','Pho bo','C1',50000, GETDATE(), 1, 5)
insert into product values ('P0002', 'img/gnocchi.jpg','Gnocchi','C2',65000, GETDATE(),1, 4.3)
insert into product values ('P0003', 'img/bunBoHue.jpg','Bun bo Hue','C1',43000, GETDATE(), 1,4.6)
insert into product values ('P0004', 'img/risotto.png','Risotto','C2',50000, GETDATE(), 1,4)
insert into product values ('P0005', 'img/Lasagna.jpg','Lasagna','C2',50000, GETDATE(), 1,3.7)
insert into product values ('P0006', 'img/comTam.jpg','Com Tam','C1',45000, GETDATE(),1 ,3.5)
insert into product values ('P0007', 'img/banh_xeo.jpg','Banh Xeo','C1',45000, GETDATE(),1, 4.9)
insert into product values ('P0008', 'img/Gujarati_Thali.jpg','Gujarati Thali','C3',50000, GETDATE(),1, 3)
insert into product values ('P0009', 'img/Caprese.jpeg','Caprese','C2',65000, GETDATE(),1, 4.2)
insert into product values ('P0010', 'img/Tiramisu.jpg','Tiramisu','C2',75000, GETDATE(),1, 5)
insert into product values ('P0011', 'img/banh_mi.jpg','Banh Mi','C1',55000, GETDATE(),1, 5)
insert into product values ('P0012', 'img/Biryani.jpeg','Biryani','C3',55000, GETDATE(),1, 4.3)
insert into product values ('P0013', 'img/Banh_Beo.jpg','Banh Beo','C1',52000, GETDATE(),1, 4.1)
insert into product values ('P0014', 'img/Gulab_jamun.jpg','Gulab Jamun','C3',41000, GETDATE(),1, 3.5)
insert into product values ('P0015', 'img/coconut_curry.jpg','Curry Chicken','C3',35000, GETDATE(),1, 4.6)
insert into product values ('P0016', 'img/Che.jpg','Che','C1',47000, GETDATE(),1, 4.8)
insert into product values ('P0017', 'img/bun_cha_ca.jpg','Bun cha ca','C1',37000, GETDATE(),1, 4.4)
insert into product values ('P0018', 'img/che_thai.jpg','Che Thai','C1',47200, GETDATE(),1, 4.2)

--insert Role
insert into roleDetail values('R01', 'Admin')
insert into roleDetail values('R02', 'User')

insert into account values ('A01','admin', 'admin', 'Cocou','R01', 'true')
insert into account values ('A02','vudnk', '12345', 'Dang Nguyen Khanh Vu','R01', 'true')
insert into account values ('A03','NVA', '12345', 'Nguyen Van A','R02', 'true')
insert into account values ('A04','NVB', '12345', 'Nguyen Van B','R02', 'true')
insert into account values ('A05','QuanDD', '12345', 'Dang Dinh Quan','R01', 'true')

