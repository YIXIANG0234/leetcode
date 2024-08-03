package edu.hhuc.leetcode.thread;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author guwanghuai
 * @version 1.0
 * @project leetcode
 * @description
 * @date 2024/7/25 15:27:53
 */
public class _1114_按序打印 {
    public static void main(String[] args) throws InterruptedException {
        PrintABC_4 printABC = new _1114_按序打印().new PrintABC_4();
        int times = 5;
        Thread t1 = new Thread(() -> {
            Random random = new Random();
            for (int i = 0; i < times; i++) {
                try {
                    printABC.first(() -> System.out.println("A"));
                    Thread.sleep(random.nextInt(10));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "线程一");
        Thread t2 = new Thread(() -> {
            Random random = new Random();
            for (int i = 0; i < times; i++) {
                try {
                    printABC.second(() -> System.out.println("B"));
                    Thread.sleep(random.nextInt(10));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "线程二");
        Thread t3 = new Thread(() -> {
            Random random = new Random();
            for (int i = 0; i < times; i++) {
                try {
                    printABC.third(() -> System.out.println("C"));
                    Thread.sleep(random.nextInt(10));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "线程三");
        t1.start();
        t2.start();
        t3.start();

    }

    class PrintABC_1 {
        private final Object lock = new Object();
        /**
         * 为什么index变量可以不加volatile?
         * 因为synchronized可以保证内存可见效
         * 1.synchronized进行加锁前，会将共享变量在工作缓存中清除，以保证能从主内存中加载最新的值
         * 2.synchronized进行解锁前，会将共享变量刷新到主内存，以保证在临界区对共享变量的最新修改同步到主内存中
         */
        private int index = 1;

        public void first(Runnable printFirst) throws InterruptedException {
            synchronized (lock) {
                while (index != 1) {
                    lock.wait();
                }
                printFirst.run();
                index = 2;
                lock.notifyAll();
            }
        }

        public void second(Runnable printSecond) throws InterruptedException {
            synchronized (lock) {
                while (index != 2) {
                    lock.wait();
                }
                printSecond.run();
                index = 3;
                lock.notifyAll();
            }
        }

        public void third(Runnable printThird) throws InterruptedException {
            synchronized (lock) {
                while (index != 3) {
                    lock.wait();
                }
                printThird.run();
                index = 1;
                lock.notifyAll();
            }
        }
    }

    class PrintABC_2 {
        private final ReentrantLock lock = new ReentrantLock();
        private final Condition condition = lock.newCondition();
        private int index = 1;

        public void first(Runnable printFirst) throws InterruptedException {
            lock.lock();
            try {
                while (index != 1) {
                    condition.await();
                }
                printFirst.run();
                index = 2;
                condition.signalAll();
            } finally {
                lock.unlock();
            }
        }

        public void second(Runnable printSecond) throws InterruptedException {
            lock.lock();
            try {
                while (index != 2) {
                    condition.await();
                }
                printSecond.run();
                index = 3;
                condition.signalAll();
            } finally {
                lock.unlock();
            }
        }

        public void third(Runnable printThird) throws InterruptedException {
            lock.lock();
            try {
                while (index != 3) {
                    condition.await();
                }
                printThird.run();
                index = 1;
                condition.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }

    class PrintABC_3 {
        private final Semaphore semaphoreA = new Semaphore(1);
        private final Semaphore semaphoreB = new Semaphore(0);
        private final Semaphore semaphoreC = new Semaphore(0);

        public void first(Runnable printFirst) throws InterruptedException {
            semaphoreA.acquire(1);
            printFirst.run();
            semaphoreB.release();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            semaphoreB.acquire(1);
            printSecond.run();
            semaphoreC.release();
        }

        public void third(Runnable printThird) throws InterruptedException {
            semaphoreC.acquire(1);
            printThird.run();
            semaphoreA.release();
        }
    }

    class PrintABC_4 {
        private final AtomicInteger state = new AtomicInteger(1);

        public void first(Runnable printFirst) throws InterruptedException {
            while (state.get() % 3 != 1) {
            }
            printFirst.run();
            state.incrementAndGet();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            while (state.get() % 3 != 2) {
            }
            printSecond.run();
            state.incrementAndGet();
        }

        public void third(Runnable printThird) throws InterruptedException {
            while (state.get() % 3 != 0) {
            }
            printThird.run();
            state.incrementAndGet();
        }
    }
}