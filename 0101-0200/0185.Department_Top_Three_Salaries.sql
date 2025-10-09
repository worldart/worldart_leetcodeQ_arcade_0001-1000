#1518ms




Select d.name as department , e1.name as employee, e1.salary as Salary
From Employee e1 join Department d on e1.DepartmentId = d.Id
Where  3 > (select count(distinct (e2.Salary))
            from  Employee e2
            where e2.Salary > e1.Salary
            and e1.DepartmentId = e2.DepartmentId)






#1518ms






# Write your MySQL query statement below
with high_earn as (
    select e.name as Employee, d.name as Department, e.salary as Salary,
dense_rank() over (partition by e.departmentId order by e.salary desc) as dranknum
from employee e
left join department d on e.departmentId = d.id)

select Department, Employee, Salary
from high_earn
where dranknum <=3
