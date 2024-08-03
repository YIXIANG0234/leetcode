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
 * @date 2024/7/26 16:02:25
 */
public class _1117_H2O生成 {
    public static void main(String[] args) {
        H2O_2 task = new _1117_H2O生成().new H2O_2();
        int n = 100;
        Thread t1 = new Thread(() -> {
            try {
                for (int i = 0; i < 2 * n; i++) {
                    task.hydrogen(() -> System.out.print("H"));
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                for (int i = 0; i < n; i++) {
                    task.oxygen(() -> System.out.print("O"));
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t1.start();
        t2.start();
    }

    class H2O_1 {
        private final Object lock = new Object();
        private int hCount = 0;
        private int oCount = 0;

        public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            synchronized (lock) {
                while (hCount == 2 && oCount < 1) {
                    lock.wait();
                }
                if (hCount == 2) {
                    hCount = 0;
                    oCount = 0;
                    System.out.println();
                }
                releaseHydrogen.run();
                hCount++;
                lock.notifyAll();
            }
        }

        public void oxygen(Runnable releaseOxygen) throws InterruptedException {
            // releaseOxygen.run() outputs "O". Do not change or remove this line.
            synchronized (lock) {
                while (oCount == 1 && hCount < 2) {
                    lock.wait();
                }
                if (oCount == 1) {
                    oCount = 0;
                    hCount = 0;
                    System.out.println();
                }
                releaseOxygen.run();
                oCount++;
                lock.notifyAll();
            }
        }
    }

    class H2O_2 {
        private final Lock lock = new ReentrantLock();
        private final Condition condition = lock.newCondition();
        private int hCount = 0;
        private int oCount = 0;

        public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            lock.lock();
            try {
                while (hCount == 2 && oCount < 1) {
                    condition.await();
                }
                if (hCount == 2) {
                    hCount = 0;
                    oCount = 0;
                    System.out.println();
                }
                releaseHydrogen.run();
                hCount++;
                condition.signalAll();
            } finally {
                lock.unlock();
            }
        }

        public void oxygen(Runnable releaseOxygen) throws InterruptedException {
            // releaseOxygen.run() outputs "O". Do not change or remove this line.
            lock.lock();
            try {
                while (oCount == 1 && hCount < 2) {
                    condition.await();
                }
                if (oCount == 1) {
                    oCount = 0;
                    hCount = 0;
                    System.out.println();
                }
                releaseOxygen.run();
                oCount++;
                condition.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }

    class H2O_3 {
        Semaphore semaphore1 = new Semaphore(2);
        Semaphore semaphore2 = new Semaphore(0);

        public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            semaphore1.acquire(1);
            releaseHydrogen.run();
            semaphore2.release();
        }

        public void oxygen(Runnable releaseOxygen) throws InterruptedException {
            // releaseOxygen.run() outputs "O". Do not change or remove this line.
            semaphore2.acquire(2);
            releaseOxygen.run();
            semaphore1.release(2);
        }
    }
}
