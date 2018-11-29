import pymysql
from prettytable import PrettyTable

#Connect to MYSQL server ,databse
db = pymysql.connect("localhost","root","password","inmar" )
cursor = db.cursor()

#Execute query
cursor.execute("select emp_name,emp_title,gendar,hire_date,dept_name,dept_mgr_name,dept_mgr_title from(select a.dept_no,concat(concat(b.first_name,' '),b.last_name) emp_name,c.title emp_title,b.hire_date,b.gendar from dept_emp a,employees b,titles c where a.emp_no=b.emp_no and b.emp_no=c.emp_no) a,  (select a.*,concat(concat(c.first_name,' '),c.last_name) dept_mgr_name,d.title dept_mgr_title from departments a,dept_manager b,employees c,titles d where a.dept_no=b.dept_no and b.emp_no=c.emp_no and c.emp_no=d.emp_no) b where a.dept_no=b.dept_no")

#Get Column names
column_list=[]
desc= cursor.description
for each in desc:
    column_list.append(each[0])
    
result_table = PrettyTable(column_list)

#get output into table and print
row = cursor.fetchall()
for each in row:
    result_table.add_row(each)

print(result_table)
db.close()
