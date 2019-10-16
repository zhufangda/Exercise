-- 查询课程编号为“02”的总成绩
SELECT SUM(s_score)
FROM Score
WHERE c_id='02'