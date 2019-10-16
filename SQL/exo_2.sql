-- 2、查询平均成绩大于60分的学生的学号和平均成绩
SELECT s_id, AVG(s_score)
FROM Score
GROUP BY s_id
HAVING AVG(s_score)>60