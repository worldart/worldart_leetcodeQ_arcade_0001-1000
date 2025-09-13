#277ms



# Write your MySQL query statement below
SELECT (
  SELECT DISTINCT salary
  FROM Employee
  ORDER BY salary DESC
  LIMIT 1 OFFSET 1
) AS SecondHighestSalary;




#258ms




# Write your MySQL query statement below
select max(salary) as SecondHighestSalary from employee 
where salary < (select max(salary) from employee)
