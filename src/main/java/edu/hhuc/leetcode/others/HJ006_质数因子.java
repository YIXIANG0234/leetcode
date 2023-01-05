package edu.hhuc.leetcode.others;

import java.util.*;
import java.util.stream.Collectors;

public class HJ006_质数因子 {
    public static void main(String[] args) {
        test();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.close();
        if (n == 1) {
            System.out.println(n);
            return;
        }
        int sqrt = (int) Math.sqrt(n);
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= sqrt; i++) {
            while (n % i == 0) {
                list.add(i);
                n = n / i;
            }
        }
        if (n != 1) {
            list.add(n);
        }
        String result = list.stream().map(String::valueOf).collect(Collectors.joining(" "));
        System.out.println(result);
    }

    public static void test(){
        Map<String, Integer> map = new HashMap<>();
        map.put("Apple", 7299);
        map.put("SAMSUNG", 6000);
        map.put("Meizu", 2698);
        map.put("Xiaomi", 2400);

        System.out.println("未排序输出结果：");
        System.out.println(map);

        System.out.println("根据key排序：");
        System.out.println(map.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toList()));

        System.out.println("根据value排序：");
        System.out.println(map.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toList()));
    }
}
