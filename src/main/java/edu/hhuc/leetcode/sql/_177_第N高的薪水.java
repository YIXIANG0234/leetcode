package edu.hhuc.leetcode.sql;

/**
 * @program: leetcode
 * @ClassName _177_第N高的薪水
 * @description:
 * @author: gaoya
 * @create: 2023-01-05 17:39
 * @Version 1.0
 */
public class _177_第N高的薪水 {
/*
方法一：dense_rank函数
select salary from (select salary, dense_rank() over(order by salary desc) as `rank` from Employee) a where a.rank=N limit 1;
方法二：row_number+if函数，也可以使用case when函数
select IF(max(salary_no) < 2, null, min(salary))
from (select salary, row_number() over (order by salary desc) salary_no from Employee group by salary order by salary desc limit 2) a
方法三：group by分组
select salary from Employee group by salary order by salary desc limit N,1;
方法四：distinct去重
select distinct salary from Employee order by salary desc limit N,1
方法五：自连接
SELECT e1.salary FROM Employee e1 JOIN Employee e2 ON e1.salary <= e2.salary GROUP BY e1.salary HAVING count(DISTINCT e2.salary) = N;
 */
}
