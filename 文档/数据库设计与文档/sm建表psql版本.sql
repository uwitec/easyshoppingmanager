DROP TABLE Users;
DROP TABLE Supplier;
DROP TABLE Customer;
DROP TABLE CommodityCategory;
DROP TABLE Commodity;
DROP TABLE PurchaseRecord;
DROP TABLE SaleRecord;


CREATE TABLE Users(
	name		varchar(20)	not null,
	password 	varchar(20)	not null,
	isAdmin		boolean		not null,
	remark		varchar(100),
	PRIMARY KEY(name)
);

CREATE TABLE Supplier(
	supplierId	serial		not null,
	name		varchar(100)	DEFAULT '一般供应商'	not null,
	contactName	varchar(20),
	contactPhone1	varchar(20),
	contactPhone2	varchar(20),
	address		varchar(100),
	PRIMARY KEY(supplierId)
);

CREATE TABLE Customer(
	customerId	serial		not null,
	customerName	varchar(100)	DEFAULT '散客'		not null,
	contactName	varchar(20),
	contactPhone1	varchar(20),
	contactPhone2	varchar(20),
	customerAddress	varchar(100),
	customerRemark	varchar(100),
	PRIMARY KEY(customerId)
);

CREATE TABLE CommodityCategory(
	categoryName	varchar(20)	not null,
	categoryRemark	varchar(100),
	PRIMARY KEY(categoryName)
);

CREATE TABLE Commodity(
	commidityId	serial		not null,
	commodityName	varchar(50)	not null,
	specification	varchar(50),
	unit		varchar(20)	not null,
	price		decimal		not null,
	quantity	int 		DEFAULT 0		not null,
	minQuantity	int 		DEFAULT	0		not null,
	commodityRemark	varchar(100),
	categoryName	varchar(20),
	PRIMARY KEY(commodityName,unit)
);
--增加商品到商品类别的外键约束
ALTER TABLE Commodity ADD CONSTRAINT CommodityToCCategory
	FOREIGN KEY (categoryName) 
	REFERENCES CommodityCategory (categoryName) 
	ON DELETE RESTRICT 
	ON UPDATE CASCADE;

CREATE TABLE PurchaseRecord(
	purchaseId	serial		not null,
	commodityName	varchar(50)	not null,
	specification	varchar(50),
	unit		varchar(20)	not null,
	price		decimal		not null,
	quantity	int 		not null,
	accountPaid	decimal		not null,
	accountNotPaid	decimal		not null,
	purchaseDate	date		not null,
	purchaseRemark	varchar(100),
	supplierId	int 		not null,
	userName	varchar(20)	not null,
	PRIMARY KEY(purchaseId)
);
--增加采购记录到供货商，录入用户，商品的外键约束
ALTER TABLE PurchaseRecord ADD CONSTRAINT PRecordToCommodity
	FOREIGN KEY (commodityName,unit)
	REFERENCES Commodity (commodityName,unit) 
	ON DELETE RESTRICT 
	ON UPDATE CASCADE;

ALTER TABLE PurchaseRecord ADD CONSTRAINT PRecordToSupplier
	FOREIGN KEY (supplierId)
	REFERENCES Supplier (supplierId) 
	ON DELETE RESTRICT 
	ON UPDATE CASCADE;
	
ALTER TABLE PurchaseRecord ADD CONSTRAINT PRecordToUsers
	FOREIGN KEY (userName)
	REFERENCES Users (name) 
	ON DELETE RESTRICT 
	ON UPDATE CASCADE;	
	
CREATE TABLE SaleRecord(
	saleId		serial		not null,
	commodityName	varchar(50)	not null,
	specification	varchar(50),
	unit		varchar(20)	not null,
	price		decimal		not null,
	quantity	int 		not null,
	accountPaid	decimal		not null,
	accountNotPaid	decimal		not null,
	purchaseDate	date		not null,
	purchaseRemark	varchar(100),
	supplierId	int 		not null,
	userName	varchar(20)	not null,
	PRIMARY KEY(saleId)
);

--增加销售记录到供货商，录入用户，商品的外键约束
ALTER TABLE SaleRecord ADD CONSTRAINT SRecordToCommodity
	FOREIGN KEY (commodityName,unit)
	REFERENCES Commodity (commodityName,unit) 
	ON DELETE RESTRICT 
	ON UPDATE CASCADE;

ALTER TABLE SaleRecord ADD CONSTRAINT SRecordToSupplier
	FOREIGN KEY (supplierId)
	REFERENCES Supplier (supplierId) 
	ON DELETE RESTRICT 
	ON UPDATE CASCADE;
	
ALTER TABLE SaleRecord ADD CONSTRAINT SRecordToUsers
	FOREIGN KEY (userName)
	REFERENCES Users (name) 
	ON DELETE RESTRICT 
	ON UPDATE CASCADE;	









