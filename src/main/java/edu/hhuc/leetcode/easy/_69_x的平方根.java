package edu.hhuc.leetcode.easy;

public class _69_x的平方根 {
    public static void main(String[] args) {
        _69_x的平方根 instance = new _69_x的平方根();
//        System.out.println(instance.solution2(2147395599));
        int a = 2147395599;
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE+1);
    }
    /**
     * 暴力破解
     *
     * @param
     * @return
     */
    public int solution1(int x) {
        int i = 1;
        while (true) {
            if (i * i < x) {
                i++;
            } else if (i * i == x) {
                return i;
            } else {
                return i - 1;
            }
        }
    }

    /**
     * 实在是不大理解这种写法为什么没有通过
     * @param x
     * @return
     */
    public int solution2(int x) {
        int left = 0;
        int right = x;
        int result = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            long mul = mid * mid;
            if (mul == x) {
                return mid;
            }
            if (mul > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
                result = mid;
            }
        }
        return result;
    }
}
