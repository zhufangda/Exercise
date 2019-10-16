-- 4、查询姓“张”的老师的个数
SELECT COUNT(t_id)
FROM Teacher
WHERE t_name LIKE '张%'