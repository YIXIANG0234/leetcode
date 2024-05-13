package edu.hhuc.leetcode.sql;

/**
 * @program: leetcode
 * @ClassName _182_查找重复的电子邮箱
 * @description:
 * @author: gaoya
 * @create: 2023-01-09 16:02
 * @Version 1.0
 */
public class _182_查找重复的电子邮箱 {
/*
方法一：
select Email from Person group by Email having count(1)>1;
方法二：使用row_number开窗函数
select distinct(a.Email) from (select Email,row_number() over(partition by Email) as email_no from Person) a where email_no>=2;
 */
}
