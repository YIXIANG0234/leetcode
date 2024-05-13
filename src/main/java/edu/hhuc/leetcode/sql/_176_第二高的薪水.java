package edu.hhuc.leetcode.sql;

/**
 * @program: leetcode
 * @ClassName _176_第二高的薪水
 * @description:
 * @author: gaoya
 * @create: 2023-01-05 17:07
 * @Version 1.0
 */
public class _176_第二高的薪水 {
/*
方法一：limit+子查询
select (select distinct salary from Employee order by salary desc limit 1,1) SecondHighestSalary;
方法二：limit+ifnull函数
select ifnull((select distinct salary from Employee order by salary desc limit 1,1), null) SecondHighestSalary;
方法三：只用max函数
select max(salary) SecondHighestSalary from Employee where salary<(select max(salary) from Employee);
方法四：dense_rank函数
select (select salary from (select salary, dense_rank() over(order by salary desc) as `rank` from Employee) a where a.rank=2 limit 1) SecondHighestSalary;
*/
}
