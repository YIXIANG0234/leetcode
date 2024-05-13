package edu.hhuc.leetcode.others;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: leetcode
 * @ClassName 携程_线程交替打印
 * @description:
 * @author: gaoya
 * @create: 2023-02-16 16:19
 * @Version 1.0
 */
public class 携程_线程交替打印 {
    private Lock lock = new ReentrantLock();
    private int state = 0;//通过state的值来确定是哪个线程打印

    public static void main(String[] args) {
        携程_线程交替打印 instance = new 携程_线程交替打印();
//        instance.method1();
//        instance.method2();
        instance.method3();
    }

    public void method1() {
        PrintTask task = new PrintTask();

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();
    }

    public void method2() {
        Number number = new Number();
        Thread t1 = new Thread(number);
        Thread t2 = new Thread(number);

        t1.setName("线程1");
        t2.setName("线程2");

        t1.start();
        t2.start();
    }

    class PrintTask implements Runnable {
        private int current = 1;

        @Override
        public void run() {
            while (current <= 100) {
                synchronized (this) {
                    notify();
                    System.out.println(Thread.currentThread().getName() + "正在打印数字：" + current);
                    current++;
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    class Number implements Runnable {
        private int number = 1;
        private Object obj = new Object();

        @Override
        public void run() {
            while (true) {
                //synchronized (this) {此处this就是Number  只new了一次可以充当同步锁
                synchronized (obj) {//继承Runnable方式，obj不需要加static修饰就可以共享
                    obj.notify();
                    if (number <= 100) {
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + ":" + number);
                        number++;
                        try {
                            //调用wait()方法的线程进入阻塞状态,并且释放锁
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        break;
                    }
                }

            }

        }
    }

    class ThreadA extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; ) {
                try {
                    lock.lock();
                    if (state % 3 == 0) {// 多线程并发，不能用if，必须用循环测试等待条件，避免虚假唤醒
                        System.out.print("A");
                        state++;
                        i++;
                    }
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    class ThreadB extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; ) {
                try {
                    lock.lock();
                    if (state % 3 == 1) {
                        System.out.print("B");
                        state++;
                        i++;
                    }
                } finally {
                    lock.unlock();
                }
            }
        }
    }


    class ThreadC extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; ) {
                try {
                    lock.lock();
                    if (state % 3 == 2) {
                        System.out.println("C");
                        state++;
                        i++;
                    }
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public void method3() {
        new ThreadA().start();
        new ThreadB().start();
        new ThreadC().start();
    }
}
