-- 查询所有课程成绩小于60分的学生的学号、姓名
SELECT student.s_id, student.s_name
FROM student
WHERE s_id NOT IN (SELECT s_id FROM score where s_score >= 60)