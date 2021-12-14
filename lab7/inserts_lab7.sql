USE lab_7;

INSERT into degree(title) values
('K.T.N'),
('D.T.N'),
('None');

INSERT into academic_status(title) values
('Docent'),
('Proffessor'),
('None');

INSERT into positions(title) values
('Lecturer'),
('Architecht'),
('None');

INSERT into employees(surname, name, middle_name, seniority, date_of_birth, passport_series_number, positions_id, academic_status_id, degree_id) values
('Pavelchak', 'Andrii', 'Whatever', 18, '1974-03-10', 'KC157485', 1, 1, 1),
('Androsiuk', 'Andrii', 'Omelianovych', 0, '1944-01-17', 'LO148828', 2, 3, 1),
('Abobuh', 'Andrii', 'Stepanovych', 10, '1900-08-03', 'MB228228', 1, 3, 1),
('Veres', 'Andrii', 'Ivanovych', 40, '1984-06-23', 'IT133776', 3, 3, 2),
('Nytrebych', 'Andrii', 'Mykhailovych', 78, '1863-05-01', 'HO412396', 1, 2, 3);

INSERT into discipline(title, semester, code, form_of_reception) values
('Math_p1', 1, 228, 'E'),
('Math_p2', 2, 229, 'E'),
('Math_p3', 3, 230, 'Z'),
('Discrete math', 2, 1488, 'Z'),
('Programmig_p2', 2, 1337, 'E'),
('Algorithms', 3, 4396, 'E');

INSERT into discipline_has_employees(discipline_id, employees_id) values
(1, 1),
(2, 5),
(3, 5),
(4, 5),
(5, 4),
(6, 4),
(5, 1),
(6, 3),
(4, 3),
(1, 2);
