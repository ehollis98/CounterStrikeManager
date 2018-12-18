DELETE FROM report;
DELETE FROM role;
DELETE FROM user;
INSERT INTO user (user_Id, first_name, last_name, user_name, pass) VALUES (1, 'Eric', 'Hollis', 'ehollis98', 'root');
INSERT INTO role (id, role_name, user_name, user_id) VALUES (1, 'admin', 'ehollis98', 1);
INSERT INTO report (id, date, name, steam_number_one, steam_number_two, statistic_type) VALUES (1, 'TestReport', 0, 0, 'test');
