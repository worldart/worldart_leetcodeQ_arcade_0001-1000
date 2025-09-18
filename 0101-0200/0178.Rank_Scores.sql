#382ms




SELECT S.score ,COUNT(S2.SCORE) as `rank` FROM SCORES S,
(SELECT DISTINCT SCORE FROM SCORES)  S2
WHERE S.SCORE<=S2.SCORE 
GROUP BY S.ID 
ORDER BY S.SCORE DESC;





#274ms






select score,
dense_rank() over (order by score desc) as 'rank'
from scores
order by score desc






#317ms






SELECT score, DENSE_RANK() OVER (ORDER BY score DESC) as 'rank' FROM Scores
