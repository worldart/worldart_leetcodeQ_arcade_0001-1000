//401ms




SELECT EMP.name AS Employee FROM Employee EMP,Employee MGR
WHERE EMP.managerId=MGR.id AND EMP.salary>MGR.salary






//389ms






Select  e1.name as Employee 
from Employee e1
Join Employee e2 on e2.id = e1.managerId
WHERE e1.salary > e2.salary;
