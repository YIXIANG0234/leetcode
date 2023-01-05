package edu.hhuc.leetcode.others;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

/**
 * 题目描述：
 * 输入某年某月某日，求这一天是这一年的第几天和星期几。注意：0表示星期天，1表示星期一，依此类推；
 * <p>
 * 输入描述：
 * 输入包括一行,分别是年月日。以空格分割,保证日期合法。
 * <p>
 * 输出描述：
 * 在一行依次输出这一天是这一年的第几天和星期几,以空格分割。
 * <p>
 * 示例：
 * 输入：2016 3 1
 * 输出：61 2
 */
public class 天翼云研发三部_计算日期 {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int year = in.nextInt();
        int month = in.nextInt();
        int day = in.nextInt();
        in.close();

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String date = String.format("%d-%d-%d", year, month, day);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(format.parse(date));
        String result = String.format("%d %d", calendar.get(Calendar.DAY_OF_YEAR), calendar.get(Calendar.DAY_OF_WEEK) - 1);
        System.out.println(result);
    }
}
