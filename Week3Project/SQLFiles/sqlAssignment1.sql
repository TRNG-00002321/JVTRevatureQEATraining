CREATE DATABASE IF NOT EXISTS test;

USE test;

DROP IF EXISTS people;
DROP IF EXISTS men;
DROP IF EXISTS women;
DROP IF EXISTS phones;
DROP IF EXISTS cars; 

CREATE TABLE people (
  id INTEGER AUTO_INCREMENT PRIMARY KEY,
  name TEXT NOT NULL,
  age INTEGER NOT NULL,
  phone INTEGER UNIQUE,
  has_car BOOLEAN NOT NULL
);

CREATE TABLE men (
  name VARCHAR(50), 
  age INTEGER DEFAULT 21,
  pay REAL
);

CREATE TABLE women (
  name VARCHAR(50), 
  age INTEGER,
  pay REAL DEFAULT 25.25
);

CREATE TABLE phones (
  call_id VARCHAR(12) PRIMARY KEY,
  model TEXT NOT NULL,
  owner_id INTEGER, 
  FOREIGN KEY (owner_id) REFERENCES people (id)
);

CREATE TABLE cars (
  id INTEGER AUTO_INCREMENT PRIMARY KEY,
  make VARCHAR(30) NOT NULL,
  model TEXT NOT NULL,
  driver_id INTEGER, 
  FOREIGN KEY (driver_id) REFERENCES people (id)
);

ALTER TABLE men ADD pid INTEGER;
ALTER TABLE men ADD CONSTRAINT person_constraint FOREIGN KEY (pid) REFERENCES people (id) ON DELETE CASCADE ON ADD CASCADE;
ALTER TABLE women DROP pay;
ALTER TABLE cars ADD year_num INTEGER NOT NULL;
ALTER TABLE people ADD CONSTRAINT phone_constraint FOREIGN KEY (phone) REFERENCES phones (call_id) ON DELETE SET NULL ON UPDATE RESTRICT;

DROP TABLE women;
DROP TABLE men CASCADE;

INSERT INTO people (name, age, phone, has_car) VALUES 
('Guy1', 27, '672-342-1456', TRUE),('Girl2', 27, '672-342-1376', FALSE),('Gal3', 27, NULL, TRUE),('Guy4', 27, NULL, TRUE),('Gal5', 27, '632-345-1116', FALSE);

INSERT INTO phones (call_id, model) VALUES 
('672-342-1456', 'Samsung S112'),('672-342-1376', 'Blackberry GTX'),('632-345-1116', 'Android G72'),('115-962-2334', 'iPhone Stone');

INSERT INTO cars (make, model, year_num) VALUES
('Zeep', 'Deep', 8932),('Yummerz', 'Hummer', 2008),('Tesla', 'Model P', 2067),('Ford', 'Model T', 1920);

UPDATE people SET age = 21 WHERE id < 6;
DELETE cars WHERE year_num < 1990;