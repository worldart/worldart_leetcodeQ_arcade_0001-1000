//801ms





DELETE p1 FROM Person p1
JOIN Person p2 
ON p1.email = p2.email AND p1.id > p2.id;






//617ms






DELETE FROM Person
WHERE id NOT IN (
    SELECT id
    FROM (
        SELECT MIN(id) id
        FROM Person
        GROUP BY email
    ) temp
);






//493ms






with keep as(
    select min(id) as min_id from
        Person
        group by email
    
)
delete from Person
where id not in 
(select min_id from keep)
    
