package edu.hhuc.leetcode.sql;

/**
 * @program: leetcode
 * @ClassName _511_游戏玩法分析I
 * @description:
 * @author: gaoya
 * @create: 2023-03-05 17:30
 * @Version 1.0
 */
public class _511_游戏玩法分析I {
/*
方法一：group by+聚合函数
select player_id,min(event_date) as first_login from Activity group by player_id;
方法二：row_number(或者dense_rank,rank)等开窗函数
select player_id,event_date as first_login from (select player_id, event_date, row_number() over(partition by player_id order by event_date) date_no from Activity) where date_no=1;
 */
}
