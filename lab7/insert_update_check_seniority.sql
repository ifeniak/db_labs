USE lab_7;
DELIMITER //

DROP trigger if exists check_before_insert_employees//
DROP trigger if exists check_before_update_employees//

CREATE trigger check_before_insert_employees
before insert
on employees for each row
begin
	if new.seniority > YEAR(curdate())-YEAR(new.date_of_birth+15) then
		SIGNAL SQLSTATE '45000'
		set MESSAGE_TEXT = "De la merde, your seniority is too big.";
	end if;
end//
 
CREATE trigger check_before_update_employees
before update
on employees for each row
begin
	if new.seniority > YEAR(curdate())-YEAR(new.date_of_birth+15) then
		SIGNAL SQLSTATE '45000'
		set MESSAGE_TEXT = "De la merde, your seniority is too big.";
	end if;
end//
