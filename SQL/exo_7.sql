SELECT student.s_id, student.s_name
FROM student JOIN score ON score.s_id=student.s_id and score.c_id='01' 
JOIN score as b ON student.s_id=b.s_id and b.c_id='02'


