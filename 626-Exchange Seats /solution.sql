# Write your MySQL query statement below
select id-1 as id, student
from seat
where id%2=0
union
select id+1 as id, student
from seat
where id%2=1 and id <> (select max(id) from seat)
union
select id, student
from seat
where id%2=1 and id = (select max(id) from seat)
order by id;