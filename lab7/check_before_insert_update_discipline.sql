USE lab_7;
DELIMITER //

DROP trigger if exists check_before_insert_discipline//
DROP trigger if exists check_before_update_discipline//

CREATE trigger check_before_insert_discipline
before insert
on discipline for each row
begin
	if char_length(new.code) != 5 then
		SIGNAL SQLSTATE '45000'
		set MESSAGE_TEXT = "Codenumber wrong! Enter code in format: first character should be 'B','M' or 'C' then separator '.' and 3 digits after that.";
	else if not (new.code regexp('^[BMC].[0-9][0-9][0-9]')) then
			SIGNAL SQLSTATE '45000'
			set MESSAGE_TEXT = "Codenumber wrong! Enter code in format: first character should be 'B','M' or 'C' then separator '.' and 3 digits after that.";
    	end if;
	end if;
    
end//
 
CREATE trigger check_before_update_discipline
before update
on discipline for each row
begin
	if char_length(new.code) != 5 then
		SIGNAL SQLSTATE '45000'
		set MESSAGE_TEXT = "Codenumber wrong! Enter code in format: first character should be 'B','M' or 'C' then separator '.' and 3 digits after that.";
	else if not (new.code regexp('^[BMC].[0-9][0-9][0-9]')) then
			SIGNAL SQLSTATE '45000'
			set MESSAGE_TEXT = "Codenumber wrong! Enter code in format: first character should be 'B','M' or 'C' then separator '.' and 3 digits after that.";
    	end if;
	end if;
end//
