package edu.hhuc.leetcode.thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * @author guwanghuai
 * @version 1.0
 * @project leetcode
 * @description
 * @date 2024/7/26 16:50:07
 */
public class _1195_交替打印字符串 {
    public static void main(String[] args) {
        FizzBuzz4 task = new _1195_交替打印字符串().new FizzBuzz4(20);
        Thread t1 = new Thread(() -> {
            try {
                task.fizz(() -> System.out.print("fizz"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "线程一");

        Thread t2 = new Thread(() -> {
            try {
                task.buzz(() -> System.out.print("buzz"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "线程二");

        Thread t3 = new Thread(() -> {
            try {
                task.fizzbuzz(() -> System.out.print("fizzbuzz"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "线程三");

        Thread t4 = new Thread(() -> {
            try {
                task.number(System.out::print);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "线程四");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

    class FizzBuzz1 {
        private int n;
        private int current = 1;
        private final Object lock = new Object();

        public FizzBuzz1(int n) {
            this.n = n;
        }

        // printFizz.run() outputs "fizz".
        public void fizz(Runnable printFizz) throws InterruptedException {
            while (current <= n) {
                synchronized (lock) {
                    if (current <= n) {
                        if (current % 3 == 0 && current % 5 != 0) {
                            printFizz.run();
                            if (current < n) {
                                System.out.print(", ");
                            }
                            current++;
                        }
                    }
                }
            }
        }

        // printBuzz.run() outputs "buzz".
        public void buzz(Runnable printBuzz) throws InterruptedException {
            while (current <= n) {
                synchronized (lock) {
                    if (current <= n) {
                        if (current % 5 == 0 && current % 3 != 0) {
                            printBuzz.run();
                            if (current < n) {
                                System.out.print(", ");
                            }
                            current++;
                        }
                    }
                }
            }
        }

        // printFizzBuzz.run() outputs "fizzbuzz".
        public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
            while (current <= n) {
                synchronized (lock) {
                    if (current <= n) {
                        if (current % 3 == 0 && current % 5 == 0) {
                            printFizzBuzz.run();
                            if (current < n) {
                                System.out.print(", ");
                            }
                            current++;
                        }
                    }
                }
            }
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void number(IntConsumer printNumber) throws InterruptedException {
            while (current <= n) {
                synchronized (lock) {
                    if (current <= n) {
                        if (current % 3 != 0 && current % 5 != 0) {
                            printNumber.accept(current);
                            if (current < n) {
                                System.out.print(", ");
                            }
                            current++;
                        }
                    }
                }
            }
        }
    }

    class FizzBuzz2 {
        private int n;
        private int current = 1;
        private final Lock lock = new ReentrantLock();

        public FizzBuzz2(int n) {
            this.n = n;
        }

        // printFizz.run() outputs "fizz".
        public void fizz(Runnable printFizz) throws InterruptedException {
            while (current <= n) {
                lock.lock();
                try {
                    if (current <= n) {
                        if (current % 3 == 0 && current % 5 != 0) {
                            printFizz.run();
                            if (current < n) {
                                System.out.print(", ");
                            }
                            current++;
                        }
                    }
                } finally {
                    lock.unlock();
                }
            }
        }

        // printBuzz.run() outputs "buzz".
        public void buzz(Runnable printBuzz) throws InterruptedException {
            while (current <= n) {
                lock.lock();
                try {
                    if (current <= n) {
                        if (current % 5 == 0 && current % 3 != 0) {
                            printBuzz.run();
                            if (current < n) {
                                System.out.print(", ");
                            }
                            current++;
                        }
                    }

                } finally {
                    lock.unlock();
                }
            }
        }

        // printFizzBuzz.run() outputs "fizzbuzz".
        public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
            while (current <= n) {
                lock.lock();
                try {
                    if (current <= n) {
                        if (current % 3 == 0 && current % 5 == 0) {
                            printFizzBuzz.run();
                            if (current < n) {
                                System.out.print(", ");
                            }
                            current++;
                        }
                    }
                } finally {
                    lock.unlock();
                }
            }
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void number(IntConsumer printNumber) throws InterruptedException {
            while (current <= n) {
                lock.lock();
                try {
                    if (current <= n) {
                        if (current % 3 != 0 && current % 5 != 0) {
                            printNumber.accept(current);
                            if (current < n) {
                                System.out.print(", ");
                            }
                            current++;
                        }
                    }
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    class FizzBuzz3 {
        private final int n;
        private final Semaphore semaphore1 = new Semaphore(0);
        private final Semaphore semaphore2 = new Semaphore(0);
        private final Semaphore semaphore3 = new Semaphore(0);
        private final Semaphore semaphore4 = new Semaphore(1);

        public FizzBuzz3(int n) {
            this.n = n;
        }

        // printFizz.run() outputs "fizz".
        public void fizz(Runnable printFizz) throws InterruptedException {
            for (int i = 3; i <= n; i = i + 3) {
                if (i % 3 == 0 && i % 5 != 0) {
                    semaphore1.acquire(1);
                    printFizz.run();
                    if (i < n) {
                        System.out.print(", ");
                    }
                    semaphore4.release();
                }
            }
        }

        // printBuzz.run() outputs "buzz".
        public void buzz(Runnable printBuzz) throws InterruptedException {

            for (int i = 5; i <= n; i++) {
                if (i % 3 != 0 && i % 5 == 0) {
                    semaphore2.acquire(1);
                    printBuzz.run();
                    if (i < n) {
                        System.out.print(", ");
                    }
                    semaphore4.release();
                }
            }
        }

        // printFizzBuzz.run() outputs "fizzbuzz".
        public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
            for (int i = 15; i <= n; i++) {
                if (i % 3 == 0 && i % 5 == 0) {
                    semaphore3.acquire(1);
                    printFizzBuzz.run();
                    if (i < n) {
                        System.out.print(", ");
                    }
                    semaphore4.release();
                }
            }
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void number(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i++) {
                semaphore4.acquire(1);
                if (i % 3 == 0 && i % 5 == 0) {
                    semaphore3.release();
                } else if (i % 5 == 0) {
                    semaphore2.release();
                } else if (i % 3 == 0) {
                    semaphore1.release();
                } else {
                    printNumber.accept(i);
                    if (i < n) {
                        System.out.print(", ");
                    }
                    semaphore4.release();
                }
            }
        }
    }

    class FizzBuzz4 {
        private final int n;
        private int current = 1;
        private final Semaphore semaphore1 = new Semaphore(0);
        private final Semaphore semaphore2 = new Semaphore(0);
        private final Semaphore semaphore3 = new Semaphore(0);
        private final Semaphore semaphore4 = new Semaphore(1);

        public FizzBuzz4(int n) {
            this.n = n;
        }

        // printFizz.run() outputs "fizz".
        public void fizz(Runnable printFizz) throws InterruptedException {
            while (current <= n) {
                // System.out.println("he:" + Thread.currentThread().getName());
                semaphore1.acquire(1);
                if (current > n) {
                    return;
                }
                if (current % 3 == 0 && current % 5 != 0) {
                    printFizz.run();
                    if (current < n) {
                        System.out.print(", ");
                    }
                    current++;
                }
                semaphore4.release();
            }
            releaseAll();
        }

        // printBuzz.run() outputs "buzz".
        public void buzz(Runnable printBuzz) throws InterruptedException {
            while (current <= n) {
                // System.out.println("he:" + Thread.currentThread().getName());
                semaphore2.acquire(1);
                if (current > n) {
                    return;
                }
                if (current % 3 != 0 && current % 5 == 0) {
                    printBuzz.run();
                    if (current < n) {
                        System.out.print(", ");
                    }
                    current++;
                }
                semaphore4.release();
            }
            releaseAll();
        }

        // printFizzBuzz.run() outputs "fizzbuzz".
        public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
            while (current <= n) {
                // System.out.println("he:" + Thread.currentThread().getName());
                semaphore3.acquire(1);
                if (current > n) {
                    return;
                }
                if (current % 3 == 0 && current % 5 == 0) {
                    printFizzBuzz.run();
                    if (current < n) {
                        System.out.print(", ");
                    }
                    current++;
                }
                semaphore4.release();
            }
            releaseAll();
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void number(IntConsumer printNumber) throws InterruptedException {
            while (current <= n) {
                // System.out.println("he:" + Thread.currentThread().getName());
                semaphore4.acquire(1);
                if (current > n) {
                    return;
                }
                if (current % 3 == 0 && current % 5 == 0) {
                    semaphore3.release();
                } else if (current % 5 == 0) {
                    semaphore2.release();
                } else if (current % 3 == 0) {
                    semaphore1.release();
                } else {
                    printNumber.accept(current);
                    if (current < n) {
                        System.out.print(", ");
                    }
                    current++;
                    semaphore4.release();
                }
            }
            releaseAll();
        }

        private void releaseAll() {
            // System.out.println("releaseAll:" + Thread.currentThread().getName());
            semaphore1.release();
            semaphore2.release();
            semaphore3.release();
            semaphore4.release();
        }
    }
}
