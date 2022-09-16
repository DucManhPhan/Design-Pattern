
-- CREATE DATABASE IF NOT EXISTS cashflow;

-- USE cashflow;

-- DROP TABLE IF EXISTS income;
-- DROP TABLE IF EXISTS expense;

CREATE TABLE income (
  id int NOT NULL AUTO_INCREMENT,
  description varchar(128) NOT NULL,
  amount DECIMAL(6,2) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE expense (
  id int NOT NULL AUTO_INCREMENT,
  description varchar(128) NOT NULL,
  amount DECIMAL(6,2) NOT NULL,
  PRIMARY KEY (id)
);
