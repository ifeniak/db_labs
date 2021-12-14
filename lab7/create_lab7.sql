CREATE database if not exists lab_7;
USE lab_7;

DROP table if exists employees;
DROP table if exists discipline;
DROP table if exists positions;
DROP table if exists academic_status;
DROP table if exists degree;
DROP table if exists form_of_reception;
DROP table if exists discipline_has_employees;

CREATE table employees (
	id int auto_increment,
    surname varchar(45) not null,
    name varchar(45) not null,
    middle_name varchar(45),
    seniority double,
    date_of_birth date,
    passport_series_number varchar(45) not null,
    positions_id int not null,
    academic_status_id int not null,
    degree_id int not null,
    constraint pk_empolyees primary key(id)
);

CREATE table discipline (
	id int auto_increment,
    title varchar(45) not null,
    semester int,
    code int,
    form_of_reception char(1) not null,
    constraint pk_discipline primary key(id)
);

CREATE table positions (
	id int auto_increment,
    title varchar(45) not null,
    constraint pk_positions primary key(id)
);

CREATE table academic_status (
	id int auto_increment,
    title varchar(45) not null,
    constraint pk_academic_status primary key(id)
);

CREATE table degree (
	id int auto_increment,
    title varchar(45) not null,
    constraint pk_degree primary key(id)
);

CREATE table form_of_reception (
	title char(1),
    full_title varchar(20) not null,
    constraint pk_form_of_reception primary key(title)
);

CREATE table discipline_has_employees (
	discipline_id int,
    employees_id int,
    constraint pk_discipline_has_employees primary key(discipline_id, employees_id)
);

INSERT into form_of_reception(title, full_title) values
('E', 'Exams'), 
('Z', 'Zalik');
