
CREATE TABLE IF NOT EXISTS departments(
	dept_no char(4),
    dept_name varchar(40), 
    PRIMARY KEY(dept_no));

CREATE TABLE IF NOT EXISTS employees(
	emp_no int(11),
    birth_date DATE, 
    first_name varchar(14),
    last_name varchar(16),
    gendar enum('M','F'),
    hire_date DATE, 
    PRIMARY KEY(emp_no));

CREATE TABLE IF NOT EXISTS dept_emp(
   emp_no int(11),
   dept_no char(4),
   from_date DATE,
   to_date DATE, 
   FOREIGN KEY fk_de_deptno(dept_no)
   REFERENCES departments(dept_no),
   FOREIGN KEY fk_de_empno(emp_no)
   REFERENCES employees(emp_no)
   ON UPDATE CASCADE
   ON DELETE RESTRICT
);

CREATE TABLE IF NOT EXISTS dept_manager(
   dept_no char(4),
   emp_no int(11),   
   from_date DATE,
   to_date DATE, 
   FOREIGN KEY fk_dm_deptno(dept_no)
   REFERENCES departments(dept_no),
   FOREIGN KEY fk_dm_empno(emp_no)
   REFERENCES employees(emp_no)
   ON UPDATE CASCADE
   ON DELETE RESTRICT
);

CREATE TABLE IF NOT EXISTS salaries(
	emp_no int(11),
    salary int(11), 
    from_date DATE,
	to_date DATE,  
    PRIMARY KEY(from_date),
    FOREIGN KEY fk_s_empno(emp_no)
    REFERENCES employees(emp_no)
    );

CREATE TABLE IF NOT EXISTS titles(
	emp_no int(11),
    title varchar(50), 
    from_date DATE,
	to_date DATE,  
    PRIMARY KEY(title,from_date),
    FOREIGN KEY fk_t_empno(emp_no)
    REFERENCES employees(emp_no)
    );

drop table departments;
ALTER table departments CHANGE deptname dept_name varchar(40);

INSERT INTO departments(dept_no,dept_name) values(1,'ACCOUNTING');
INSERT INTO departments(dept_no,dept_name) values(2,'RESEARCH');
INSERT INTO departments(dept_no,dept_name) values(3,'SALES');
INSERT INTO departments(dept_no,dept_name) values(4,'OPERATIONS');
commit;

select * from departments;

INSERT INTO employees(emp_no,birth_date,first_name,last_name,gendar,hire_date) 
values(100,'1981-06-29','Chris','Marry','F','2006-12-10');
INSERT INTO employees(emp_no,birth_date,first_name,last_name,gendar,hire_date) 
values(101,'1991-05-10','John','Adam','M','2014-10-29');
INSERT INTO employees(emp_no,birth_date,first_name,last_name,gendar,hire_date) 
values(102,'1991-04-09','Shiva','kumar','M','2014-11-12');
INSERT INTO employees(emp_no,birth_date,first_name,last_name,gendar,hire_date) 
values(103,'1993-05-10','Samir','Beria','M','2015-02-23');
INSERT INTO employees(emp_no,birth_date,first_name,last_name,gendar,hire_date) 
values(104,'1992-01-12','Vishal','Mantri','M','2015-08-11');
INSERT INTO employees(emp_no,birth_date,first_name,last_name,gendar,hire_date) 
values(105,'1986-03-12','Vishaal','kant','M','2015-08-12');
INSERT INTO employees(emp_no,birth_date,first_name,last_name,gendar,hire_date) 
values(106,'1984-01-08','Gajjar','Suneel','M','2016-06-15');
INSERT INTO employees(emp_no,birth_date,first_name,last_name,gendar,hire_date) 
values(107,'1986-03-12','Marc','Weinfeld','M','2016-10-10');
commit;

select * from titles;

INSERT INTO dept_emp(emp_no,dept_no,from_date,to_date) values(101,1,'2014-10-29',curdate());
INSERT INTO dept_emp(emp_no,dept_no,from_date,to_date) values(102,2,'2014-11-12',curdate());
INSERT INTO dept_emp(emp_no,dept_no,from_date,to_date) values(103,3,'2015-02-23',curdate());
INSERT INTO dept_emp(emp_no,dept_no,from_date,to_date) values(104,4,'2015-08-11',curdate());

INSERT INTO dept_manager(emp_no,salary,from_date,to_date) values(100,1,'2006-12-10',curdate());
INSERT INTO dept_manager(emp_no,salary,from_date,to_date) values(105,2,'2015-08-12',curdate());
INSERT INTO dept_manager(emp_no,salary,from_date,to_date) values(106,3,'2016-06-15',curdate());
INSERT INTO dept_manager(emp_no,salary,from_date,to_date) values(107,4,'2016-10-10',curdate());

delete from dept_emp where emp_no=103;


INSERT INTO salaries(emp_no,salary,from_date,to_date) values(100,1500000,'2006-12-10',curdate());
INSERT INTO salaries(emp_no,salary,from_date,to_date) values(101,800000,'2014-10-29',curdate());
INSERT INTO salaries(emp_no,salary,from_date,to_date) values(102,900000,'2014-11-12',curdate());
INSERT INTO salaries(emp_no,salary,from_date,to_date) values(103,1000000,'2015-02-23',curdate());
INSERT INTO salaries(emp_no,salary,from_date,to_date) values(104,1000000,'2015-08-11',curdate());
INSERT INTO salaries(emp_no,salary,from_date,to_date) values(105,700000,'2015-08-12',curdate());
INSERT INTO salaries(emp_no,salary,from_date,to_date) values(106,120000,'2016-06-15',curdate());
INSERT INTO salaries(emp_no,salary,from_date,to_date) values(107,130000,'2016-10-10',curdate());

INSERT INTO titles(emp_no,title,from_date,to_date) values(100,'Accounting_Manager','2006-12-10',curdate());
INSERT INTO titles(emp_no,title,from_date,to_date) values(101,'Accounting_Employee','2014-10-29',curdate());
INSERT INTO titles(emp_no,title,from_date,to_date) values(102,'Research_Employee','2014-11-12',curdate());
INSERT INTO titles(emp_no,title,from_date,to_date) values(103,'Sales_Employee','2015-02-23',curdate());
INSERT INTO titles(emp_no,title,from_date,to_date) values(104,'Operations_Employee','2015-08-11',curdate());
INSERT INTO titles(emp_no,title,from_date,to_date) values(105,'Research_Manager','2015-08-12',curdate());
INSERT INTO titles(emp_no,title,from_date,to_date) values(106,'Sales_Manager','2016-06-15',curdate());
INSERT INTO titles(emp_no,title,from_date,to_date) values(107,'Operations_Manager','2016-10-10',curdate());




select b.emp_no ,concat(concat(b.first_name,' '),b.last_name) emp_name,e.title ,b.gendar,b.hire_date,a.dept_no from departments a,employees b ,dept_emp c,
dept_manager d,titles e  where b.emp_no=c.emp_no and a.dept_no=c.dept_no and  b.emp_no=e.emp_no ;


departments a, dept_manager d,titles e  ;



select a.emp_name,a.title,a.gendar,a.hire_date,b.dept_no from (select b.emp_no ,concat(concat(b.first_name,' '),b.last_name) emp_name ,b.gendar,b.hire_date,e.title from employees b,titles e
where b.emp_no=e.emp_no)a, dept_emp b where a.emp_no=b.emp_no;


select a.*,b.* from (select a.emp_name,a.title,a.gendar,a.hire_date,b.dept_no from (select b.emp_no ,concat(concat(b.first_name,' '),b.last_name) emp_name ,b.gendar,b.hire_date,e.title from employees b,titles e
where b.emp_no=e.emp_no)a, dept_emp b where a.emp_no=b.emp_no)a ,(select g.*,e.title dept_mgr_title from (
select f.dept_no,f.dept_name,concat(concat(b.first_name,' '),b.last_name) dept_mgr_name,b.emp_no from
(select a.*,d.emp_no from departments a ,dept_manager d where a.dept_no=d.dept_no)f,employees b  where f.emp_no=b.emp_no) g,titles e
where g.emp_no=e.emp_no)b where a.dept_no=b.dept_no;
;

select concat(concat(b.first_name,' '),b.last_name) emp_name,e.title,b.gendar,b.hire_date from employees b,titles e where
b.emp_no =e.emp_no ;

select g.*,e.title dept_mgr_title from (
select f.dept_no,f.dept_name,concat(concat(b.first_name,' '),b.last_name) dept_mgr_name,b.emp_no from
(select a.*,d.emp_no from departments a ,dept_manager d where a.dept_no=d.dept_no)f,employees b  where f.emp_no=b.emp_no) g,titles e
where g.emp_no=e.emp_no;


select a.*,b.* from(
select b.emp_no ,concat(concat(b.first_name,' '),b.last_name) emp_name ,b.gendar,b.hire_date from employees b) a,
(select g.*,e.title dept_mgr_title from (
select f.dept_no,f.dept_name,concat(concat(b.first_name,' '),b.last_name) dept_mgr_name,b.emp_no from
(select a.*,d.emp_no from departments a ,dept_manager d where a.dept_no=d.dept_no)f,employees b  where f.emp_no=b.emp_no) g,titles e
where g.emp_no=e.emp_no) b where a.dept_no=b.dept_no;






