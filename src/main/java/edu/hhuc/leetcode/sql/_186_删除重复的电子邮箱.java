package edu.hhuc.leetcode.sql;

/**
 * @program: leetcode
 * @ClassName _186_删除重复的电子邮箱
 * @description:
 * @author: gaoya
 * @create: 2023-01-09 18:45
 * @Version 1.0
 */
public class _186_删除重复的电子邮箱 {
/*
方法一：group by+子查询
delete from Person where id not in(select id from (SELECT min(id) id from Person group by email) t)
方法二：连接查询
DELETE p1 FROM Person p1,
    Person p2
WHERE
    p1.Email = p2.Email AND p1.Id > p2.Id
方法三：row_number+子查询
delete from Person where id in (select id from (select id, row_number() over(partition by email order by id) email_no from Person) t where email_no>=2);
 */
}
