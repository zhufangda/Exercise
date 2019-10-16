-- 5.查询没学过“张三”老师课的学生的学号、姓名(重点)
-- Solution 1
SELECT s_id, s_name
FROM Student
WHERE s_id IN
(SELECT score.s_id FROM Score JOIN Course ON Score.c_id=Course.c_id 
JOIN teacher ON teacher.t_id=Course.t_id WHERE teacher.t_name='张三' 
);

-- Solution 2
SELECT student.s_id, student.s_name
FROM (student JOIN score ON student.s_id=score.s_id
JOIN course ON course.c_id=score.c_id)
JOIN teacher ON teacher.t_id=course.t_id 
where teacher.t_name = '张三'