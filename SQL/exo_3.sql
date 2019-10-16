-- 3、查询所有学生的学号、姓名、选课数、总成绩
SELECT student.s_id, student.s_name, COUNT(score.c_id), SUM(score.s_score)
FROM Student
JOIN Score ON student.s_id = score.s_id
GROUP BY s_id