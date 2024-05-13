package edu.hhuc.leetcode.sql;

/**
 * @program: leetcode
 * @ClassName _183_从不订购的客户
 * @description:
 * @author: gaoya
 * @create: 2023-01-09 16:05
 * @Version 1.0
 */
public class _183_从不订购的客户 {
/*
方法一：
select a.Name Customers from Customers a left join Orders b on a.id=b.CustomerId where b.id is null;
方法二：
select a.Name Customers from Customers where id not in (select CustomerId from Orders);
 */
}
