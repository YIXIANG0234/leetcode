package edu.hhuc.leetcode.sql;

/**
 * @program: leetcode
 * @ClassName _178_分数排名
 * @description:
 * @author: gaoya
 * @create: 2023-01-05 18:29
 * @Version 1.0
 */
public class _178_分数排名 {
/*
方法一：dense_rank函数
select score,dense_rank() over(order by score desc) `rank` from Scores;
方法二：子查询
select a.score,(select count(distinct b.score) from Scores b where b.score>=a.score) `rank` from Scores a order by a.score desc;
*/
}
