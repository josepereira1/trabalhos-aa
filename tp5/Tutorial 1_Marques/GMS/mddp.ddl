CREATE TABLE `User` (Name varchar(255) NOT NULL, Email varchar(255), Password varchar(255), PRIMARY KEY (Name));
CREATE TABLE Game (Name varchar(255) NOT NULL, PlatformName varchar(255), Year int(10) NOT NULL, Price float NOT NULL, Description varchar(255), PRIMARY KEY (Name));
CREATE TABLE Platform (Name varchar(255) NOT NULL, Year int(10) NOT NULL, Description varchar(255), Manufacturer varchar(255), PRIMARY KEY (Name));
CREATE TABLE User_Game (UserName varchar(255) NOT NULL, GameName varchar(255) NOT NULL, PRIMARY KEY (UserName, GameName));
ALTER TABLE Game ADD CONSTRAINT FKGame309537 FOREIGN KEY (PlatformName) REFERENCES Platform (Name);
ALTER TABLE User_Game ADD CONSTRAINT FKUser_Game192947 FOREIGN KEY (UserName) REFERENCES `User` (Name);
ALTER TABLE User_Game ADD CONSTRAINT FKUser_Game79458 FOREIGN KEY (GameName) REFERENCES Game (Name);
