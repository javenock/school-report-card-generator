INSERT INTO student (regno, fname, form, gender, sirname, year,status, english, kiswahili, mathematics, biology, chemistry, physics, geography, history, cre, agriculture, business, computer, homescience, stream) VALUES
(100, 'kondoo', 'ONE', 'male', 'Gemgem', '2020','Class Prefect', '', '', '', '', '', '', '', 'HISTORY', '', '', '', '', '', 'SOUTH'),
(102, 'Collins', 'ONE', 'male', 'sooooo', '2020','Class Prefect', 'ENGLISH', 'KISWAHILI', 'MATHEMATICS', 'BIOLOGY', 'CHEMISTRY', '', 'GEOGRAPHY', '', '', '', 'BUSINESS', 'COMPUTER', '', 'WEST'),
(200, 'Jane', 'THREE', 'male', 'Ngairi', '2020','Class Prefect', 'ENGLISH', 'KISWAHILI', 'MATHEMATICS', 'BIOLOGY', 'CHEMISTRY', '', '', 'HISTORY', 'CRE', '', '', '', 'HOMESCIENCE', 'NORTH'),
(201, 'polypi', 'THREE', 'male', 'mettoo', '2020','Computer Lab Prefect', 'ENGLISH', 'KISWAHILI', 'MATHEMATICS', 'BIOLOGY', 'CHEMISTRY', 'PHYSICS','', 'HISTORY', '', 'AGRICULTURE', '', '', '', 'WEST'),
(202, 'kelvin', 'ONE', 'male', 'bitok', '2020','Class Prefect', '', '', '', '', '', '', 'GEOGRAPHY', '', '', '', '', '', '', 'SOUTH'),
(203, 'collins', 'ONE', 'male', 'komboo', '2020','Dorm Prefect', '', '', '', '', '', '', '', 'HISTORY', '', '', '', '', '', 'EAST'),
(204, 'maryanne', 'THREE', 'Female', 'Maombo', '2020','Class Prefect', 'ENGLISH', 'KISWAHILI', 'MATHEMATICS', 'BIOLOGY', 'CHEMISTRY', 'PHYSICS','', '', 'CRE', 'AGRICULTURE', '', '', '', 'NORTH'),
(205, 'Metrine', 'THREE', 'Female', 'Jcky', '2020','School Head Boy', 'ENGLISH', 'KISWAHILI', 'MATHEMATICS', 'BIOLOGY', 'CHEMISTRY', 'PHYSICS', '', 'HISTORY', '', '', '', '', '', 'EAST'),
(221, 'Enock', 'FOUR', 'Male', 'Wangila', '2020','Normal Student', 'ENGLISH', 'KISWAHILI', 'MATHEMATICS', 'BIOLOGY', 'CHEMISTRY', 'PHYSICS', '', 'HISTORY', '', 'AGRICULTURE', '', '', '', 'EAST'),
(302, 'kelvin', 'ONE', 'male', 'bitok', '2020','Class Prefect', '', '', '', '', '', '', 'GEOGRAPHY', '', '', '', '', '', '', 'SOUTH'),
(303, 'collins', 'ONE', 'male', 'komboo', '2020','Dorm Prefect', '', '', '', '', '', '', '', 'HISTORY', '', '', '', '', '', 'EAST'),
(304, 'maryanne', 'FOUR', 'Female', 'Maombo', '2020','Class Prefect', 'ENGLISH', 'KISWAHILI', 'MATHEMATICS', 'BIOLOGY', 'CHEMISTRY', 'PHYSICS','', '', 'CRE', 'AGRICULTURE', '', '', '', 'NORTH'),
(305, 'Metrine', 'FOUR', 'Female', 'Jcky', '2020','School Head Boy', 'ENGLISH', 'KISWAHILI', 'MATHEMATICS', 'BIOLOGY', 'CHEMISTRY', 'PHYSICS', '', 'HISTORY', '', '', '', '', '', 'EAST'),
(321, 'Enock', 'THREE', 'Male', 'Wangila', '2020','Normal Student', 'ENGLISH', 'KISWAHILI', 'MATHEMATICS', 'BIOLOGY', 'CHEMISTRY', 'PHYSICS', '', 'HISTORY', '', 'AGRICULTURE', '', '', '', 'EAST');

INSERT INTO teachers(idno, fname, form, othername, phone, rank, stream) 
			VALUES (500, 'DANIEL','ALL', 'WAMBUGU', 070856253, 'PRINCIPAL', 'ALL'),
				(501, 'KUBAI D','THREE', 'THURANIRA', 070852253, 'CLASS TEACHER', 'NORTH'),
				(502, 'BENDICT','THREE', 'SONGWA', 070856253, 'CLASS TEACHER', 'EAST'),
				(503, 'ROSELYNE','THREE', 'MUKEKHE', 070856253, 'CLASS TEACHER', 'SOUTH'),
				(504, 'WYCLIFFE','THREE', 'BARASA', 070856253, 'CLASS TEACHER', 'WEST'),
				(505, 'BRAMUEL','ONE', 'MALOMO', 070854253, 'CLASS TEACHER', 'SOUTH');


create table if not exists persistent_logins (username varchar(100) not null,series varchar(64) primary key, token varchar(64) not null,last_used timestamp not null);

delete from  user_role;
delete from  roles;
delete from  users;


INSERT INTO roles (id, name) VALUES 
(1, 'ROLE_ADMIN'),
(2, 'ROLE_ACTUATOR'),
(3, 'ROLE_USER')
;

INSERT INTO users (id, email, password, name) VALUES 
(1, 'admin@gmail.com', '$2a$10$hKDVYxLefVHV/vtuPhWD3OigtRyOykRLDdUAp80Z1crSoS1lFqaFS', 'Admin'),
(3, 'user@gmail.com', '$2a$10$ByIUiNaRfBKSV6urZoBBxe4UbJ/sS6u1ZaPORHF9AtNWAuVPVz1by', 'User'),
(4, 'classt@gmail.com', '$2a$10$ByIUiNaRfBKSV6urZoBBxe4UbJ/sS6u1ZaPORHF9AtNWAuVPVz1by', 'Teacher');


insert into user_role(user_id, role_id) values
(1,1),
(1,2),
(1,3),
(3,3),
(4,2)
;