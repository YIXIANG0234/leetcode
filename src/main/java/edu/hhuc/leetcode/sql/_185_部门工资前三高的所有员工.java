package edu.hhuc.leetcode.sql;

/**
 * @program: leetcode
 * @ClassName _185_部门工资前三高的所有员工
 * @description:
 * @author: gaoya
 * @create: 2023-01-09 18:31
 * @Version 1.0
 */
public class _185_部门工资前三高的所有员工 {
/*
方法一：dense_rank函数
select Department,Employee,Salary from (
    select e.name Employee,e.salary,d.name Department, dense_rank() over(partition by e.departmentId order by salary desc) as `rank_serail` from Employee e join Department d on e.departmentId=d.id)
    temp where rank_serail<=3;
方法二：子查询
select e1.name Employee,e1.salary,d.name Department from Employee e1 join Department d on e1.departmentId=d.id
where 3>(
select count(distinct salary) from Employee e2 where e2.salary>e1.salary and e2.departmentId=e1.departmentId)
;
 */
}
