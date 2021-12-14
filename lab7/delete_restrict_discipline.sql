USE lab_7;
DELIMITER //

DROP trigger if exists restrict_before_delete_discipline//

CREATE trigger restrict_before_delete_discipline
before delete
on discipline for each row
begin
	SIGNAL SQLSTATE '45000'
	set MESSAGE_TEXT = "No u can't.";
end//
