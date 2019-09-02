# Write your MySQL query statement below
# Not working
#select t.Id from Weather t, Weather y where t.RecordDate = y.RecordDate+1 and t.Temperature > y.Temperature;
# Working
select t.Id from Weather t, Weather y where datediff(t.RecordDate,y.RecordDate) = 1 and t.Temperature > y.Temperature;
