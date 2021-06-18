# Write your MySQL query statement below
select d.name as department, e.name as employee, e.salary
from Employee e, Department d, (select departmentId, max(salary) as salary
                                 from Employee
                                 group by departmentId) m
where e.departmentId = d.id and d.id = m.departmentId and m.salary = e.salary;