-- 5.查询没学过“张三”老师课的学生的学号、姓名(重点)

select s_id, s_name
from Student
where s_id not in 
(select s_id from Score join Course on Score.c_id = Course.c_id
join Teacher on Course.t_id = Teacher.t_id
where t_name = '张三');