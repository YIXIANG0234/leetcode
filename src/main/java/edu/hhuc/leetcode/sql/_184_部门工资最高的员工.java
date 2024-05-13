package edu.hhuc.leetcode.sql;

/**
 * @program: leetcode
 * @ClassName _184_部门工资最高的员工
 * @description:
 * @author: gaoya
 * @create: 2023-01-09 16:10
 * @Version 1.0
 */
public class _184_部门工资最高的员工 {
/*
方法一：in的骚操作
select d.name Department, e.name Employee, e.Salary from Employee e join Department d on e.departmentId=d.id where (e.departmentId, e.salary) in (
select departmentId,max(salary) from Employee group by departmentId);
方法二：rank over+子查询
select Department,Employee,Salary from (select e.name Employee,e.salary,d.name Department, rank() over(partition by e.departmentId order by salary desc) as `rank_serail` from Employee e join Department d on e.departmentId=d.id) temp where rank_serail=1;
 */
}
