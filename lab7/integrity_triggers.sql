USE lab_7;
DELIMITER //

DROP trigger if exists before_insert_form_of_reception//
DROP trigger if exists before_update_form_of_reception//
DROP trigger if exists before_delete_form_of_reception//
DROP trigger if exists before_delete_degree//
DROP trigger if exists before_delete_academic_status//
DROP trigger if exists before_delete_positions//
DROP trigger if exists before_insert_employees//
DROP trigger if exists before_update_employees//
DROP trigger if exists before_delete_employees//
DROP trigger if exists before_insert_discipline//
DROP trigger if exists before_update_discipline//
DROP trigger if exists before_delete_discipline//
DROP trigger if exists before_insert_discipline_has_employees//
DROP trigger if exists before_update_discipline_has_employees//

-- form_of_reception
CREATE trigger before_insert_form_of_reception
before insert
on form_of_reception for each row
begin
	SIGNAL SQLSTATE '45000'
    set MESSAGE_TEXT = "Cannot add new row to form_of_reception: Table is immutable.";
end//
 
CREATE trigger before_update_form_of_reception
before update
on form_of_reception for each row
begin
	SIGNAL SQLSTATE '45000'
    set MESSAGE_TEXT = "Cannot update row of form_of_reception: Table is immutable.";
end//
 
CREATE trigger before_delete_form_of_reception
before delete
on form_of_reception for each row
begin
	SIGNAL SQLSTATE '45000'
    set MESSAGE_TEXT = "Cannot delete row of form_of_reception: Table is immutable.";
end// 

-- degree 
CREATE trigger before_delete_degree
before delete
on degree for each row
begin
	if old.id = (select degree_id from empoyees) then
		SIGNAL SQLSTATE '45000'
		set MESSAGE_TEXT = "What are you doing? This id is present in another table.";
	end if;
end// 

-- academic_status 
CREATE trigger before_delete_academic_status
before delete
on academic_status for each row
begin
	if old.id = (select academic_status_id from empoyees) then
		SIGNAL SQLSTATE '45000'
		set MESSAGE_TEXT = "What are you doing? This id is present in another table.";
	end if;
end// 

-- positions
 CREATE trigger before_delete_positions
before delete
on positions for each row
begin
	if old.id = (select positions_id from empoyees) then
		SIGNAL SQLSTATE '45000'
		set MESSAGE_TEXT = "What are you doing? This id is present in another table.";
	end if;
end// 

-- employees
 CREATE trigger before_insert_employees
before insert
on employees for each row
begin
	if (new.positions_id not in (select id from positions)) or
	   (new.degree_id not in (select id from degree)) or
       (new.academic_status_id not in (select id from academic_status)) then
		SIGNAL SQLSTATE '45000'
		set MESSAGE_TEXT = "Sorry, that id cannot be foreign key.";
	end if;
end//
 
CREATE trigger before_update_employees
before update
on employees for each row
begin
	if (new.positions_id not in (select id from positions)) or
	   (new.degree_id not in (select id from degree)) or
       (new.academic_status_id not in (select id from academic_status)) then
		SIGNAL SQLSTATE '45000'
		set MESSAGE_TEXT = "Sorry, that id cannot be foreign key.";
	end if;
end//
 
CREATE trigger before_delete_employees
before delete
on employees for each row
begin
	if old.id in (select employees_id from discipline_has_employees) then
		SIGNAL SQLSTATE '45000'
		set MESSAGE_TEXT = "Hold on! This employee is still assigned to one or more discipline.";
	end if;
end// 

-- discipline 
 CREATE trigger before_insert_discipline
before insert
on discipline for each row
begin
	if new.form_of_reception not in (select title from form_of_reception) then
		SIGNAL SQLSTATE '45000'
		set MESSAGE_TEXT = "Sorry, that id cannot be foreign key.";
	end if;
end//
 
CREATE trigger before_update_discipline
before update
on discipline for each row
begin
	if new.form_of_reception not in (select title from form_of_reception) then
		SIGNAL SQLSTATE '45000'
		set MESSAGE_TEXT = "Sorry, that id cannot be foreign key.";
	end if;
end//
 
CREATE trigger before_delete_discipline
before delete
on discipline for each row
begin
	if old.id in (select discipline_id from discipline_has_employees) then
		SIGNAL SQLSTATE '45000'
		set MESSAGE_TEXT = "Hold on! One or more empoyees are assigned to this discipline.";
	end if;
end//

-- discipline_has_employees 
 CREATE trigger before_insert_discipline_has_employees
before insert
on discipline_has_employees for each row
begin
	if (new.employees_id not in (select id from employees)) or 
	   (new.discipline_id not in (select id from discipline)) then
		SIGNAL SQLSTATE '45000'
		set MESSAGE_TEXT = "Damn, employee or discipline, with your id doesn't even exist.";
	end if;
end//
 
CREATE trigger before_update_discipline_has_employees
before update
on discipline_has_employees for each row
begin
	if (new.employees_id not in (select id from employees)) or 
	   (new.discipline_id not in (select id from discipline)) then
		SIGNAL SQLSTATE '45000'
		set MESSAGE_TEXT = "Damn, employee or discipline, with your id doesn't even exist.";
	end if;
end//
