package edu.hhuc.leetcode.sql;

/**
 * @program: leetcode
 * @ClassName _197_上升的温度
 * @description:
 * @author: gaoya
 * @create: 2023-03-05 17:20
 * @Version 1.0
 */
public class _197_上升的温度 {
/*
方法一：连接查询+date_sub函数
select a.id Id from Weather a, Weather b where date_sub(a.recordDate, INTERVAL 1 day)=b.recordDate and a.temperature>b.temperature;
方法二：连接查询+DATEDIFF函数
select a.id Id from Weather a, Weather b where DATEDIFF(a.recordDate, b.recordDate)=1 and a.temperature>b.temperature;
 */
}
