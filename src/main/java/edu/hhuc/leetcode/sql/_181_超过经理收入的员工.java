package edu.hhuc.leetcode.sql;

/**
 * @program: leetcode
 * @ClassName _181_超过经理收入的员工
 * @description:
 * @author: gaoya
 * @create: 2023-01-09 15:54
 * @Version 1.0
 */
public class _181_超过经理收入的员工 {
/*
方法一：
select a.name Employee from Employee a join Employee b on a.managerId=b.id and a.salary>b.salary;
方法二：
select a.name Employee from Employee a, Employee b where a.managerId=b.id and a.salary>b.salary;
 */
}
