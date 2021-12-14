USE lab_7;
set global log_bin_trust_function_creators = 1;
DELIMITER //

DROP function if exists discipline_avg_semester//
DROP function if exists select_academic_status//
CREATE function discipline_avg_semester() returns decimal
begin
	return(select avg(semester) from discipline);
end;

SELECT * from discipline
	where semester < discipline_avg_semester()//

CREATE function select_academic_status( id_select int ) returns varchar(45)
begin
	return(select title from academic_status 
				where id = (select academic_status_id from employees 
								where id=id_select));
end;

SELECT id, surname, name, middle_name, seniority, date_of_birth, passport_series_number, positions_id, degree_id, select_academic_status(id) as academic_status from employees//
