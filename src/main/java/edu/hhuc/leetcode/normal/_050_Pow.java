package edu.hhuc.leetcode.normal;

public class _050_Pow {
    public static void main(String[] args) {
        _050_Pow instance = new _050_Pow();
        System.out.println(instance.solution2(2, 10));
    }

    /**
     * 不要问我为啥这么写，因为官方给的测试用例n如果取反有可能还是负数，例如n=-2147483648,-n还是-2147483648
     * 所以定义了myPow，n的类型设置为long
     * @param x
     * @param n
     * @return
     */
    public double solution1(double x, int n) {
        return myPow(x, (long)n);
    }
    public double myPow(double x, long n) {
        if (n == 0 || x == 1) {
            return 1;
        }
        if (n < 0) {
            return 1 / myPow(x, -n);
        }
        if (n % 2 != 0) {
            return x * myPow(x, n - 1);
        }
        double result = myPow(x, n / 2);
        return result * result;
    }

    public double solution2(double x, int n) {
        if (x == 1 || n == 0) {
            return 1;
        }
        long temp = n;
        if (temp < 0) {
            temp = -temp;
        }
        double contribute = x;
        double result = 1;
        while (temp > 0) {
            if (temp % 2 == 1) {
                result *= contribute;
            }
            contribute *= contribute;
            temp = temp/2;
        }
        if (n < 0) {
            result = 1 / result;
        }
        return result;
    }
}
