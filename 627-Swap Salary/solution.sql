# Write your MySQL query statement below
update salary s set sex = (case sex when 'f' then 'm' else 'f' end);