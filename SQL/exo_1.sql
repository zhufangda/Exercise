-- 1、查询课程编号为“01”的课程比“02”的课程成绩高的所有学生的学号。
-- Solution 1
SELECT a.s_id
from score as a inner join Score as b on a.s_id = b.s_id and a.s_score > b.s_score
WHERE a.c_id = '01' and b.c_id = '02';

-- Solution 2
SELECT a.s_id
from (SELECT * FROM Score where c_id = '01') as a
JOIN (SELECT * FROM SCORE where c_id = '02') as b 
ON a.s_id = b.s_id
WHERE a.s_score > b.s_score
