create table BusinessAreas(
	BusinessID bigint NOT NULL PRIMARY KEY auto_increment,
	Name varchar(255) NOT NULL,
	Code varchar(255) NOT NULL,
	createDate timestamp NULL ,
	modifyDate timestamp NULL ,
	createBy varchar(255) NULL,
	modifyBy varchar(255) NULL
);

create table Comment(
	CommentID bigint NOT NULL PRIMARY KEY auto_increment,
	UserID bigint NOT NULL,
	Content varchar(255) NOT NULL,
	ItemID bigint NOT NULL,
	createDate timestamp NULL ,
	modifyDate timestamp NULL ,
	createBy varchar(255) NULL,
	modifyBy varchar(255) NULL
);

create table Cooperator (
	CooperatorID bigint NOT NULL PRIMARY KEY auto_increment,
	Name varchar(255) NOT NULL,
	Address varchar(255) NULL,
	Telephone int NULL,
	Email varchar(255) NULL,
	createDate timestamp NULL ,
	modifyDate timestamp NULL ,
	createBy varchar(255) NULL,
	modifyBy varchar(255) NULL
);

create table HistoryRent (
	HistoryID bigint NOT NULL PRIMARY KEY auto_increment,
	ItemName varchar(255) NULL,
	NumOfRent int NULL,
	TotalCost varchar(255) NULL,
	createDate timestamp NULL ,
	modifyDate timestamp NULL ,
	createBy varchar(255) NULL,
	modifyBy varchar(255) NULL
);

create table Items (
	ItemID bigint NOT NULL PRIMARY KEY auto_increment,
	NameItem varchar(255) NOT NULL,
	Thumbnail varchar(255) NULL,
	ItemDetail varchar(20000) NULL,
	TotalPrice varchar(255) NULL,
	createDate timestamp NULL ,
	modifyDate timestamp NULL ,
	createBy varchar(255) NULL,
	modifyBy varchar(255) NULL,
	BusinessID bigint NOT NULL,
	CooperatorID bigint NOT NULL
);


create table Rent (
	RentID bigint NOT NULL PRIMARY KEY auto_increment,
	UserID bigint NOT NULL,
	ItemID bigint NOT NULL,
	RentDetail varchar(255) NULL,
	Cost varchar(255) NOT NULL, 
	createDate timestamp NULL ,
	modifyDate timestamp NULL ,
	createBy varchar(255) NULL,
	modifyBy varchar(255) NULL,
	Status INT(11) NOT NULL
);
create table Visitor (
	VisitorID bigint NOT NULL PRIMARY KEY auto_increment,
	Username varchar(255) NOT NULL,
	Address varchar(255)  NULL,
	Telephone varchar(255) NOT NULL,
	RentID bigint NULL,
	Email varchar(255) NULL
);


create table Role (
	RoleID bigint NOT NULL PRIMARY KEY auto_increment,
	RoleName varchar(255) NOT NULL,
	Code varchar(255) NOT NULL,
	createDate timestamp NULL ,
	modifyDate timestamp NULL ,
	createBy varchar(255) NULL,
	modifyBy varchar(255) NULL
);

create table User (
	UserID bigint NOT NULL PRIMARY KEY auto_increment,
	Password varchar(255) NOT NULL,
	Username varchar(255) NOT NULL,
	Address varchar(255) NOT NULL,
	Email varchar(255) NULL,
	Telephone int NULL,
	Birthday varchar(255) NULL,
	Status int NOT NULL,
	createDate timestamp NULL ,
	modifyDate timestamp NULL ,
	createBy varchar(255) NULL,
	modifyBy varchar(255) NULL,
	RoleID bigint NOT NULL,
	HistoryID bigint NOT NULL
);
ALTER TABLE Visitor ADD CONSTRAINT FK_VisitorRent FOREIGN KEY (RentID) REFERENCES Rent(RentID);
ALTER TABLE Rent ADD CONSTRAINT FK_RentVisitor FOREIGN KEY (VisitorID) REFERENCES Visitor(VisitorID);
ALTER TABLE Rent ADD CONSTRAINT FK_RentUser FOREIGN KEY (UserID) REFERENCES User(UserID);
ALTER TABLE Ient ADD CONSTRAINT FK_RentItems FOREIGN KEY (ItemID) REFERENCES Items(ItemID);
ALTER TABLE Items ADD CONSTRAINT FK_ItemsBA FOREIGN KEY (BusinessID) REFERENCES BusinessAreas(BusinessID);
ALTER TABLE Items ADD CONSTRAINT FK_ItemsCoop FOREIGN KEY (CooperatorID) REFERENCES Cooperator(CooperatorID);
ALTER TABLE Comment ADD CONSTRAINT FK_CommentUser FOREIGN KEY (UserID) REFERENCES User(UserID);
ALTER TABLE Comment ADD CONSTRAINT FK_CommentItems FOREIGN KEY (ItemID) REFERENCES Items(ItemID);
ALTER TABLE User ADD CONSTRAINT FK_UserRole FOREIGN KEY (RoleID) REFERENCES Role(RoleID);
ALTER TABLE User ADD CONSTRAINT FK_UserHistory FOREIGN KEY (HistoryID) REFERENCES HistoryRent(HistoryID);