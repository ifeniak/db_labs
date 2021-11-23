USE Labor_SQL;
-- ------------------------------------------------------------------------------

-- 1. БД «Комп. фірма». Отримати інформацію про всі принтери, які не є
-- матричними та коштують менше 300 дол. Вихідні дані впорядкувати
-- за спаданням за стовпцем type .

SELECT * FROM Printer
WHERE type != 'Matrix' AND price < 300
ORDER BY type desc;
-- ------------------------------------------------------------------------------

-- 2. БД «Кораблі». З таблиці Ships вивести назви кораблів та роки їх
-- спущення на воду, назва яких не закінчується на літеру 'a' .

SELECT name, launched FROM Ships
WHERE name NOT LIKE '%a';
-- ------------------------------------------------------------------------------

-- 3. БД «Комп. фірма». Вкажіть виробника для тих ПК, що мають
-- жорсткий диск об’ємом не більше 8 Гбайт. Вивести: maker , type ,
-- speed , hd .

SELECT maker, type, speed, hd FROM PC JOIN Product ON PC.model=Product.model
WHERE hd <= 8;
-- ------------------------------------------------------------------------------

-- 4. БД «Комп. фірма». Знайдіть виробників, що випускають одночасно
-- ПК та ноутбуки (використати операцію IN ). Вивести maker .

SELECT distinct maker FROM Product
WHERE type = 'PC' AND maker IN 
(SELECT distinct maker from Product
WHERE type = 'Laptop');
-- ------------------------------------------------------------------------------

-- 5. БД «Кораблі». Знайдіть класи кораблів, у яких хоча б один корабель
-- був затоплений у битвах. Вивести: class . (Назви класів кораблів визна-
-- чати за таблицею Ships , якщо його там немає, тоді порівнювати чи
-- його назва не співпадає з назвою класу, тобто він є головним)

SELECT class FROM Outcomes JOIN Ships 
ON Outcomes.ship = Ships.name
WHERE result = 'sunk'
union
SELECT class FROM Outcomes JOIN Classes 
ON Outcomes.ship = Classes.class
WHERE result = 'sunk';
-- ------------------------------------------------------------------------------

-- 6. БД «Кораблі». З таблиці Battles виведіть дати в такому форматі:
-- рік.число_місяця.день, наприклад, 2001.02.21 (без формату часу).

SELECT DATE_FORMAT(date, '%Y.%m.%d') FROM Battles;
-- ------------------------------------------------------------------------------

-- 7. БД «Комп. фірма». Знайдіть виробників найдешевших кольорових
-- принтерів. Вивести: maker , price .

SELECT maker, price FROM Product JOIN Printer ON Product.model = Printer.model
WHERE
color = 'y'
AND
price IN (SELECT MIN(price) FROM Printer WHERE color = 'y');
-- ------------------------------------------------------------------------------

-- 8. БД «Комп. фірма». Знайдіть середній розмір жорсткого диску ПК
-- кожного з тих виробників, які випускають також і принтери. Вивести:
-- maker , середній розмір жорсткого диску. (Підказка: використовувати
-- підзапити в якості обчислювальних стовпців)

SELECT maker, AVG(hd)
FROM PC JOIN Product ON PC.model = Product.model
WHERE maker = ANY
(SELECT distinct maker FROM Printer JOIN Product ON Printer.model = Product.model)
GROUP BY maker;
-- ------------------------------------------------------------------------------

-- 9. БД «Кораблі». Визначити назви всіх кораблів із таблиці Ships , які
-- задовольняють, у крайньому випадку, комбінації будь-яких чотирьох
-- критеріїв із наступного списку: numGuns =12, bore =16,
-- displacement =46000, type = 'bc' , country = 'Gt.Britain' , launched =1941,
-- class = 'North Carolina' . Вивести: name , numGuns , bore , displacement ,
-- type , country , launched , class. (Підказка: використати для перевірки
-- умов оператор CASE)

WITH ClassCond as (
	SELECT 
    Ships.name,
    CASE numGuns WHEN 12 THEN 1 ELSE 0 END
    as counter1,
    CASE bore WHEN 16 THEN 1 ELSE 0 END
	as counter2,
    CASE displacement WHEN 46000 THEN 1 ELSE 0 END
	as counter3,
    CASE type WHEN 'bc' THEN 1 ELSE 0 END
	as counter4,
    CASE country WHEN 'Gt.Britain' THEN 1 ELSE 0 END
	as counter5,
    CASE launched WHEN 1941 THEN 1 ELSE 0 END
	as counter6,
    CASE Ships.class WHEN 'North Carolina' THEN 1 ELSE 0 END
    as counter7
    FROM Ships JOIN Classes ON Ships.class = Classes.class
)
SELECT name from ClassCond
WHERE counter1 + counter2 + counter3 + counter4 + counter5 + counter6 + counter7 >= 3;

-- ----------------------------------------------------------------------------------

-- 10. БД «Кораблі». Знайдіть назви всіх кораблів із БД, про які можна
-- однозначно сказати, що вони були спущені на воду до 1942 р. Виве-
-- сти: назву кораблів. (Підказка: використовувати оператор UNION )

SELECT name FROM Ships WHERE launched < 1942
union
SELECT ship FROM Outcomes JOIN Battles WHERE DATE_FORMAT(date, '%Y') < 1942; 

