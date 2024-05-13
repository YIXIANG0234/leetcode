package edu.hhuc.leetcode.sql;

/**
 * @program: leetcode
 * @ClassName _180_连续出现的数字
 * @description:
 * @author: gaoya
 * @create: 2023-01-05 18:48
 * @Version 1.0
 */
public class _180_连续出现的数字 {
/*
方法一：
select distinct l1.num ConsecutiveNums from Logs l1,Logs l2,Logs l3 where l1.id=l2.id+1 and l2.id=l3.id+1 and l1.num=l2.num and l2.num = l3.num;
 */
}
