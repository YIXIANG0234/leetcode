package edu.hhuc.leetcode.thread;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author guwanghuai
 * @version 1.0
 * @project leetcode
 * @description
 * @date 2024/7/29 16:27:31
 */
public class _1188_设计有限阻塞队列 {
    public static void main(String[] args) {
        String s = "a,b，c,d，e";
        System.out.println(Arrays.toString(s.split(";|,")));
        Queue3<Integer> queue = new _1188_设计有限阻塞队列().new Queue3<>(10);
        Random random = new Random();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(random.nextInt(10));
                    queue.enqueue(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "线程一");
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 17; i++) {
                try {
                    Thread.sleep(random.nextInt(10));
                    queue.dequeue();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "线程二");

        t1.start();
        t2.start();
    }


    class Queue1<T> {
        private final Object[] data;
        private final Object lock;
        private int size = 0;
        private int start;
        private int end;

        public Queue1(int threshold) {
            data = new Object[threshold];
            this.lock = new Object();
        }

        /**
         * 入队
         *
         * @param item
         */
        public void enqueue(T item) throws InterruptedException {
            synchronized (lock) {
                while (size == data.length) {
                    System.out.println("入队等待中：" + Thread.currentThread().getName());
                    lock.wait();
                }
                data[end] = item;
                if (++end == data.length) {
                    end = 0;
                }
                size++;
                System.out.println("入队：" + item);
                lock.notifyAll();
            }
        }

        /**
         * 出队
         *
         * @return
         */
        public T dequeue() throws InterruptedException {
            synchronized (lock) {
                while (size == 0) {
                    System.out.println("出队等待中：" + Thread.currentThread().getName());
                    lock.wait();
                }
                Object result = data[start];
                if (++start == data.length) {
                    start = 0;
                }
                size--;
                System.out.println("出队：" + result);
                lock.notifyAll();
                return (T) result;
            }
        }
    }

    class Queue2<T> {
        private final LinkedList<T> data;
        private final Object lock;
        private int threshold;

        public Queue2(int threshold) {
            this.threshold = threshold;
            data = new LinkedList<>();
            this.lock = new Object();
        }

        /**
         * 入队
         *
         * @param item
         */
        public void enqueue(T item) throws InterruptedException {
            synchronized (lock) {
                while (data.size() == threshold) {
                    System.out.println("入队等待中：" + Thread.currentThread().getName());
                    lock.wait();
                }
                data.offerLast(item);
                System.out.println("入队：" + item);
                lock.notifyAll();
            }
        }

        /**
         * 出队
         *
         * @return
         */
        public T dequeue() throws InterruptedException {
            synchronized (lock) {
                while (data.isEmpty()) {
                    System.out.println("出队等待中：" + Thread.currentThread().getName());
                    lock.wait();
                }
                Object result = data.pollFirst();
                System.out.println("出队：" + result);
                lock.notifyAll();
                return (T) result;
            }
        }
    }

    class Queue3<T> {
        private final Object[] data;
        private final Lock lock;
        private final Condition notEmpty;
        private final Condition notFull;
        private int size = 0;
        private int start;
        private int end;

        public Queue3(int threshold) {
            data = new Object[threshold];
            this.lock = new ReentrantLock();
            this.notEmpty = lock.newCondition();
            this.notFull = lock.newCondition();
        }

        /**
         * 入队
         *
         * @param item
         */
        public void enqueue(T item) throws InterruptedException {
            lock.lock();
            try {
                while (size == data.length) {
                    System.out.println("入队等待中：" + Thread.currentThread().getName());
                    notFull.await();
                }
                System.out.println("入队：" + item);
                data[end] = item;
                if (++end == data.length) {
                    end = 0;
                }
                size++;
                notEmpty.signalAll();
            } finally {
                lock.unlock();
            }
        }

        /**
         * 出队
         *
         * @return
         */
        public T dequeue() throws InterruptedException {
            lock.lock();
            try {
                while (size == 0) {
                    System.out.println("出队等待中：" + Thread.currentThread().getName());
                    notEmpty.await();
                }
                Object result = data[start];
                System.out.println("出队：" + result);
                if (++start == data.length) {
                    start = 0;
                }
                size--;
                notFull.signalAll();
                return (T) result;
            } finally {
                lock.unlock();
            }
        }
    }
}
