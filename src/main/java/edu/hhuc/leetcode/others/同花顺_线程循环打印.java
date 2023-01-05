package edu.hhuc.leetcode.others;

/**
 * @program: leetcode
 * @ClassName 同花顺_线程循环打印
 * @description: 3个线程循环的打印A, B, C
 * @author: gaoya
 * @create: 2022-12-12 11:06
 * @Version 1.0
 */
public class 同花顺_线程循环打印 {
    private Object lock = new Object();
    private int printNum = 0;
    private int times = 2;

    public void print(int target) {
        while (true) {
            synchronized (lock) {
                while (printNum % 3 != target) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for (int i = 0; i < times; i++) {
                    System.out.print(target + " ");
                }
                System.out.println();
                printNum++;
                lock.notifyAll();
            }
        }
    }

    public void printOddAndEven(int target, boolean isOdd) {
        while (true) {
            synchronized (lock) {
                if (printNum % 2 != 1 && !isOdd) {
                    while (printNum % 2 != 1 && !isOdd) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } else if (printNum % 2 != 0 && isOdd) {
                    while (printNum % 2 != 0 && isOdd) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println();
                        printNum++;
                        lock.notifyAll();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        同花顺_线程循环打印 instance = new 同花顺_线程循环打印();
        Thread thread1 = new Thread(() -> instance.print(0), "A");
        Thread thread2 = new Thread(() -> instance.print(1), "B");
        Thread thread3 = new Thread(() -> instance.print(2), "C");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
