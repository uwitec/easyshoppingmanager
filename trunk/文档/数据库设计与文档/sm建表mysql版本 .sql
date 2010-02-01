DROP TABLE Users;
DROP TABLE Supplier;
DROP TABLE Customer;
DROP TABLE CommodityCategory;
DROP TABLE Commodity;
DROP TABLE PurchaseRecord;
DROP TABLE SaleRecord;


CREATE TABLE Users(
	name		varchar(20)	NOT NULL,
	password 	varchar(20),
	isAdmin		boolean,
	remark		varchar(100),
	PRIMARY KEY(name)
)DEFAULT CHARSET=UTF8;

CREATE TABLE Supplier(
	supplierId bigint(20) unsigned NOT NULL auto_increment,
	name		varchar(100),
	contactName	varchar(20),
	contactPhone1	varchar(20),
	contactPhone2	varchar(20),
	address		varchar(100),
	PRIMARY KEY(supplierId)
)DEFAULT CHARSET=UTF8;

CREATE TABLE Customer(
	customerId bigint(20) unsigned NOT NULL auto_increment,
	customerName	varchar(100),
	contactName	varchar(20),
	contactPhone1	varchar(20),
	contactPhone2	varchar(20),
	customerAddress	varchar(100),
	customerRemark	varchar(100),
	PRIMARY KEY(customerId)
)DEFAULT CHARSET=UTF8;

CREATE TABLE CommodityCategory(
	categoryName	varchar(20)	NOT NULL,
	categoryRemark	varchar(100),
	PRIMARY KEY(categoryName)
)DEFAULT CHARSET=UTF8;

CREATE TABLE StoreCommodity(
	commidityId	bigint(20) unsigned NOT NULL auto_increment,
	commodityName	varchar(50)	NOT NULL,
	specification	varchar(50),
	unit		varchar(20)	NOT NULL,
	price		float,
	quantity	int,
	minQuantity	int,
	commodityRemark	varchar(100),
	categoryName	varchar(20),
	PRIMARY KEY(commidityId)
)DEFAULT CHARSET=UTF8;
--增加商品到商品类别的外键约束
ALTER TABLE StoreCommodity ADD CONSTRAINT StoreCommodityToCCategory
	FOREIGN KEY (categoryName) 
	REFERENCES CommodityCategory (categoryName) 
	ON DELETE RESTRICT 
	ON UPDATE CASCADE;

CREATE TABLE PurchaseRecord(
	purchaseId bigint(20) unsigned NOT NULL auto_increment,
	commodityName	varchar(50),
	specification	varchar(50),
	unit		varchar(20),
	price		float,
	quantity	int,
	accountPaid	float,
	accountNotPaid	float,
	purchaseDate	datetime,
	purchaseRemark	varchar(100),
	supplierId	int 		NOT NULL,
	userName	varchar(20)	NOT NULL,
	PRIMARY KEY(purchaseId)
)DEFAULT CHARSET=UTF8;
--增加采购记录到供货商，录入用户，商品的外键约束
ALTER TABLE PurchaseRecord ADD CONSTRAINT PRecordToStoreCommodity
	FOREIGN KEY (commodityName,unit)
	REFERENCES StoreCommodity (commodityName,unit) 
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
	saleId bigint(20) unsigned NOT NULL auto_increment,
	commodityName	varchar(50),
	specification	varchar(50),
	unit		varchar(20),
	price		float,
	quantity	int,
	accountPaid	float,
	accountNotPaid float,
	purchaseDate	datetime,
	purchaseRemark	varchar(100),
	supplierId	int,
	userName	varchar(20),
	PRIMARY KEY(saleId)
)DEFAULT CHARSET=UTF8;

--增加销售记录到供货商，录入用户，商品的外键约束
ALTER TABLE SaleRecord ADD CONSTRAINT SRecordToStoreCommodity
	FOREIGN KEY (commodityName,unit)
	REFERENCES StoreCommodity (commodityName,unit) 
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









