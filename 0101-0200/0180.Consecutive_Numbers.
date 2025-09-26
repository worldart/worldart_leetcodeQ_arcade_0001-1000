#646ms




with cte as 
(
    select id,num,
        lead(num) over(order by id) as num1,lead(num,2) over(order by id) as num2
    from logs
)
select distinct num as ConsecutiveNums
from cte   
where num=num1 and num1=num2




#818ms





select distinct l.num as ConsecutiveNums from logs as l
join logs as l2 on l.id=l2.id+1
join logs as l3 on l.id=l3.id+2
where l.num=l2.num and l2.num=l3.num




#513ms




# Write your MySQL query statement below
select distinct l1.num as ConsecutiveNums
from Logs l1,Logs l2,Logs l3
where l1.num = l2.num
and l2.num = l3.num
and l1.id = l2.id - 1
and l2.id = l3.id - 1
