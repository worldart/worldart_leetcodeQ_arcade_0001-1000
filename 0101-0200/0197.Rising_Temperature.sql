//435ms






SELECT today.id
FROM Weather yesterday 
CROSS JOIN Weather today

WHERE DATEDIFF(today.recordDate,yesterday.recordDate) = 1
    AND today.temperature > yesterday.temperature
;






//1261ms







select w1.id 
from Weather w1
join Weather w2 
    on w1.recordDate = DATE_ADD(w2.recordDate,interval 1 Day)
where w1.temperature > w2.temperature; 








//378ms







select x.id from Weather as x
Join weather as y
on x.recordDate = (date_add(y.recordDate, Interval 1 DAY))
where x.temperature > y.temperature;
