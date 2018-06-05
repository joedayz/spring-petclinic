create user PETCLINIC identified by PETCLINIC default tablespace USERS;

--- Asignando ROLES y Privilegios ---
grant connect,resource,dba,exp_full_database,imp_full_database to  PETCLINIC;

ALTER SESSION SET CURRENT_SCHEMA=PETCLINIC; 


CREATE TABLE PETCLINIC.vets
( 
  id          NUMBER(7)            NOT NULL,
  first_name          VARCHAR2(100 BYTE)   NOT NULL,
  last_name          VARCHAR2(100 BYTE)   NOT NULL
);

ALTER TABLE PETCLINIC.vets ADD (
  CONSTRAINT PK_vets
 PRIMARY KEY
 (id));

CREATE TABLE PETCLINIC.specialties (
  id NUMBER(7)            NOT NULL,
  name VARCHAR2(100 BYTE)   NOT NULL
) ;

ALTER TABLE PETCLINIC.specialties ADD (
  CONSTRAINT PK_specialties
 PRIMARY KEY
 (id));

CREATE TABLE PETCLINIC.vet_specialties (
  vet_id NUMBER(7)            NOT NULL,
  specialty_id NUMBER(7)            NOT NULL
) ;

ALTER TABLE PETCLINIC.vet_specialties ADD (
  CONSTRAINT FK_VETS 
 FOREIGN KEY (vet_id) 
 REFERENCES PETCLINIC.vets (id));
 
ALTER TABLE PETCLINIC.vet_specialties ADD (
  CONSTRAINT FK_specialties
 FOREIGN KEY (specialty_id) 
 REFERENCES PETCLINIC.specialties (id));

CREATE UNIQUE INDEX PETCLINIC.vet_specialties ON PETCLINIC.vet_specialties
(vet_id, specialty_id);

CREATE TABLE PETCLINIC.types (
  id NUMBER(7)            NOT NULL,
  name VARCHAR2(100 BYTE)   NOT NULL
) ;

ALTER TABLE PETCLINIC.types ADD (
  CONSTRAINT PK_types
 PRIMARY KEY
 (id));

CREATE TABLE PETCLINIC.owners (
  id NUMBER(7)            NOT NULL,
  first_name VARCHAR2(100 BYTE)   NOT NULL,
  last_name VARCHAR2(100 BYTE)   NOT NULL,
  address VARCHAR2(200 BYTE)   NOT NULL,
  city VARCHAR2(100 BYTE)   NOT NULL,
  telephone VARCHAR2(100 BYTE)   NOT NULL
) ;

ALTER TABLE PETCLINIC.owners ADD (
  CONSTRAINT PK_owners
 PRIMARY KEY
 (id));
 
CREATE TABLE PETCLINIC.pets (
  id NUMBER(7)            NOT NULL,
  name VARCHAR2(100 BYTE)   NOT NULL,
  birth_date DATE,
  type_id NUMBER(7)            NOT NULL,
  owner_id NUMBER(7)            NOT NULL
) ;

ALTER TABLE PETCLINIC.pets ADD (
  CONSTRAINT PK_pets
 PRIMARY KEY
 (id));
 
ALTER TABLE PETCLINIC.pets ADD (
  CONSTRAINT FK_pets_owner 
 FOREIGN KEY (owner_id) 
 REFERENCES PETCLINIC.owners (id));
 
ALTER TABLE PETCLINIC.pets ADD (
  CONSTRAINT FK_pets_specialties_1
 FOREIGN KEY (type_id) 
 REFERENCES PETCLINIC.types (id));
 
CREATE TABLE PETCLINIC.visits (
  id NUMBER(7)            NOT NULL,
  pet_id NUMBER(7)            NOT NULL,
  visit_date DATE,
  description VARCHAR2(100 BYTE)   NOT NULL
) ;

ALTER TABLE PETCLINIC.visits ADD (
  CONSTRAINT PK_visits
 PRIMARY KEY
 (id));
 
ALTER TABLE PETCLINIC.visits ADD (
  CONSTRAINT FK_pets
 FOREIGN KEY (pet_id) 
 REFERENCES PETCLINIC.pets (id));

