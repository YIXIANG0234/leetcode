package edu.hhuc.leetcode.thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * @author guwanghuai
 * @version 1.0
 * @project leetcode
 * @description
 * @date 2024/7/26 11:26:51
 */
public class _1116_打印零与奇偶数 {

    public static void main(String[] args) {
        ZeroEvenOdd1 task = new _1116_打印零与奇偶数().new ZeroEvenOdd1(19);
        Thread t1 = new Thread(() -> {
            try {
                task.zero(System.out::print);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "线程一");
        Thread t2 = new Thread(() -> {
            try {
                task.even(System.out::print);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "线程二");
        Thread t3 = new Thread(() -> {
            try {
                task.odd(System.out::print);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "线程三");
        t1.start();
        t2.start();
        t3.start();
    }

    class ZeroEvenOdd1 {
        private final int n;
        private final Object lock = new Object();
        private int state = 1;

        ZeroEvenOdd1(int n) {
            this.n = n;
        }

        public void zero(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i++) {
                synchronized (lock) {
                    while (state != 1) {
                        lock.wait();
                    }
                    printNumber.accept(0);
                    state = i % 2 == 0 ? 2 : 3;
                    lock.notifyAll();
                }
            }
        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            for (int i = 2; i <= n; i = i + 2) {
                synchronized (lock) {
                    while (state != 2) {
                        lock.wait();
                    }
                    printNumber.accept(i);
                    state = 1;
                    lock.notifyAll();
                }
            }
        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i = i + 2) {
                synchronized (lock) {
                    while (state != 3) {
                        lock.wait();
                    }
                    printNumber.accept(i);
                    state = 1;
                    lock.notifyAll();
                }
            }
        }
    }

    class ZeroEvenOdd2 {
        private final int n;
        private final Lock lock = new ReentrantLock();
        private final Condition condition = lock.newCondition();
        private int state = 1;

        ZeroEvenOdd2(int n) {
            this.n = n;
        }

        public void zero(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i++) {
                lock.lock();
                try {
                    while (state != 1) {
                        condition.await();
                    }
                    printNumber.accept(0);
                    state = i % 2 == 0 ? 2 : 3;
                    condition.signalAll();
                } finally {
                    lock.unlock();
                }
            }
        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            for (int i = 2; i <= n; i = i + 2) {
                lock.lock();
                try {
                    while (state != 2) {
                        condition.await();
                    }
                    printNumber.accept(i);
                    state = 1;
                    condition.signalAll();
                } finally {
                    lock.unlock();
                }
            }
        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i = i + 2) {
                lock.lock();
                try {
                    while (state != 3) {
                        condition.await();
                    }
                    printNumber.accept(i);
                    state = 1;
                    condition.signalAll();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    class ZeroEvenOdd3 {
        private final int n;
        private final Semaphore semaphore0 = new Semaphore(1);
        private final Semaphore semaphore1 = new Semaphore(0);
        private final Semaphore semaphore2 = new Semaphore(0);

        ZeroEvenOdd3(int n) {
            this.n = n;
        }

        public void zero(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i++) {
                semaphore0.acquire(1);
                printNumber.accept(0);
                if (i % 2 == 0) {
                    semaphore1.release();
                } else {
                    semaphore2.release();
                }
            }
        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            for (int i = 2; i <= n; i = i + 2) {
                semaphore1.acquire(1);
                printNumber.accept(i);
                semaphore0.release();
            }
        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i = i + 2) {
                semaphore2.acquire(1);
                printNumber.accept(i);
                semaphore0.release();
            }
        }
    }
}
