package edu.hhuc.leetcode.thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author guwanghuai
 * @version 1.0
 * @project leetcode
 * @description
 * @date 2024/7/25 21:43:39
 */
public class _1115_交替打印FooBar {

    public static void main(String[] args) {
        FooBar3 task = new _1115_交替打印FooBar().new FooBar3(5);
        Thread t1 = new Thread(() -> {
            try {
                task.foo();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                task.bar();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t1.start();
        t2.start();
    }

    class FooBar1 {
        private int n;
        private final Object lock = new Object();

        private int state = 1;

        public FooBar1(int n) {
            this.n = n;
        }

        public void foo() throws InterruptedException {
            for (int i = 0; i < n; i++) {
                synchronized (lock) {
                    while (state != 1) {
                        lock.wait();
                    }
                    System.out.print("foo");
                    state = 2;
                    lock.notifyAll();
                }
            }
        }

        public void bar() throws InterruptedException {
            for (int i = 0; i < n; i++) {
                synchronized (lock) {
                    while (state != 2) {
                        lock.wait();
                    }
                    System.out.println("bar");
                    state = 1;
                    lock.notifyAll();
                }
            }
        }
    }

    class FooBar2 {
        private int n;
        private final Lock lock = new ReentrantLock();

        private final Condition condition = lock.newCondition();

        private int state = 1;

        public FooBar2(int n) {
            this.n = n;
        }

        public void foo() throws InterruptedException {
            for (int i = 0; i < n; i++) {
                lock.lock();
                try {
                    while (state != 1) {
                        condition.await();
                    }
                    System.out.print("foo");
                    state = 2;
                    condition.signalAll();
                } finally {
                    lock.unlock();
                }
            }
        }

        public void bar() throws InterruptedException {
            for (int i = 0; i < n; i++) {
                lock.lock();
                try {
                    while (state != 2) {
                        condition.await();
                    }
                    System.out.println("bar");
                    state = 1;
                    condition.signalAll();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    class FooBar3 {
        private int n;
        Semaphore semaphore1 = new Semaphore(1);
        Semaphore semaphore2 = new Semaphore(0);

        public FooBar3(int n) {
            this.n = n;
        }

        public void foo() throws InterruptedException {
            for (int i = 0; i < n; i++) {
                semaphore1.acquire(1);
                System.out.print("foo");
                semaphore2.release();
            }
        }

        public void bar() throws InterruptedException {
            for (int i = 0; i < n; i++) {
                semaphore2.acquire(1);
                System.out.println("bar");
                semaphore1.release();
            }
        }
    }
}
