#572ms





# Write your MySQL query statement below
select d.name as Department,
e.name as Employee,
e.salary as Salary  from 
Employee e join Department d
on e.departmentId=d.id
where(e.departmentId,e.salary)in(
    select departmentId,max(salary)
    from Employee
    group by departmentId
);






#697ms






WITH
    T AS (
        SELECT
            d.name AS department,
            e.name AS employee,
            salary,
            RANK() OVER (
                PARTITION BY d.name
                ORDER BY salary DESC
            ) AS rk
        FROM
            Employee AS e
            JOIN Department AS d ON e.departmentId = d.id
    )
SELECT department, employee, salary
FROM T
WHERE rk = 1;
