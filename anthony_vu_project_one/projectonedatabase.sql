select * from application;
select * from application where admin1 = true and admin2 = true;

drop table application;
create table application(
	id serial not null,
	eid VARCHAR not null,
	todaydate VARCHAR not null,
	location VARCHAR not null,
	description VARCHAR not null,
	cost INTEGER not null,
	grade VARCHAR not null,
	typeevent VARCHAR not null,
	justification VARCHAR not null,
	reimbursement INTEGER not null,
	status VARCHAR,
	depart INTEGER,
	admin1 BOOLEAN,
	admin2 BOOLEAN,
	admin3 BOOLEAN,
	present VARCHAR,
	approvepresent VARCHAR,
	foreign key(eid)
	references employees(eid)
);

update application set admin1 = true where eid = '125' and depart = 1;

insert into application values
(default, '125', '2021-10-01', 'TX', 'This is a test run', 1000, 'Pass', 'University Class', 'This is another test', 600,'', 1, false, false, false),
(default, '100', '2021-10-11', 'TX', 'This is a test run', 1100, 'Pass', 'University Class', 'This is another test',  660,'', 3, true, false, false),
(default, '203', '2021-10-21', 'TX', 'This is a test run', 100000, 'Pass', 'University Class', 'This is another test',  60000,'', 2, true, true, false);

select * from messages;
create table messages(
	id serial primary key,
	eid VARCHAR not null,
	message VARCHAR not null
);

select * from messager;
drop table messager;
create table messager(
	id serial primary key,
	lastname VARCHAR not null,
	message VARCHAR not null
);

insert into messager values
(default, 'Kaiba', 'This is a Test Message'),
(default, 'Atem', 'You need to respect your cards Kaiba'),
(default, 'Kaiba', 'Screw the Rules I have money!');


insert into messages values
(default, '125', 'This is a Test Message, You didn''t do anything wrong!');

drop table departments;
create table departments(
	departmentid INTEGER not null,
	department VARCHAR not null,
	dsuper VARCHAR not null,
	dhead VARCHAR not null,
	benco VARCHAR not null,
	primary key(departmentid)
);

insert into departments values
(1, 'Department of the Plays', 'Kaiba', 'Pegasus', 'Atem'),
(2, 'Department of Cards', 'Ishtar', 'Mahad', 'Atem'),
(3, 'Department of the Gods', 'Kaiba', 'Mahad', 'Atem');
update employees set totalbenefit = 0 where eid = '203';
select * from employees;
drop table employees;
create table employees(
	id serial not null,
	eid VARCHAR not null,
	firstname VARCHAR not null,
	lastname VARCHAR not null,
	totalbenefit INTEGER not null,
	adminlevel INTEGER not null,
	depart Integer not null,
	foreign key(depart)
	references departments(departmentid),
	primary key(eid)
);

update employees set totalbenefit = (select totalbenefit - 600 as "Subtraction") where eid = '125';

insert into employees values
(default,'100', 'Yugi', 'Muto', 1000, 0, 3),
(default,'203', 'Ishizu', 'Ishtar', 1000, 0, 2),
(default,'125', 'Joey', 'Wheeler', 1000, 0, 1),
(default,'112', 'Mai', 'Valentine', 1000, 0, 1),
(default,'107', 'Mako', 'Tsunami', 1000, 0, 1),
(default,'818', 'Tea', 'Gardner', 1000, 0, 1),
(default,'900', 'Seto', 'Kaiba', 0, 1, 1),
(default,'901', 'Maximillion', 'Pegasus', 0, 2, 1),
(default,'902', 'Mahad', 'Mahad', 0, 2, 2),
(default,'903', 'Pharaoh', 'Atem', 0, 3, 3),
(default,'904', 'Marik', 'Ishtar', 0, 1, 2);

drop table grades;
create table grades(
	id serial primary key,
	letter VARCHAR not null,
	describegrade VARCHAR not null 
);

insert into grades values 
(default, 'A', 'Pass'),
(default, 'B', 'Pass'),
(default, 'C', 'Pass'),
(default, 'D', 'Need Presentation'),
(default, 'F', 'Fail');




