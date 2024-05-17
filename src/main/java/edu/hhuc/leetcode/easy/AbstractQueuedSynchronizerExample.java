package edu.hhuc.yixiang.base.thread;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author guwanghuai
 * @version 1.0
 * @project chase
 * @description
 * @date 2024/2/19 20:55:51
 */
public class AbstractQueuedSynchronizerExample {
    public static void main(String[] args) throws Exception {
        test3();
    }

    public static void test1() throws Exception {
        Mutex mutex = new Mutex();
        Thread t1 = new Thread(new SynchronizerTask(mutex, () -> {
            try {
                Thread.sleep(10000000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }), "线程1");

        Thread t2 = new Thread(new SynchronizerTask(mutex, () -> {
            try {
                Thread.sleep(10000000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }), "线程2");

        Thread t3 = new Thread(new SynchronizerTask(mutex, () -> {
            try {
                Thread.sleep(10000000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }), "线程3");
        t1.start();
        Thread.sleep(100);
        t2.start();
        Thread.sleep(100);
        t3.start();
    }

    public static void test2() throws Exception {
        Mutex mutex = new Mutex();
        CounterTask counterTask = new CounterTask(mutex);
        Thread t1 = new Thread(counterTask, "线程1");
        Thread t2 = new Thread(counterTask, "线程2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(counterTask.getCounter());
    }

    public static void test3() throws Exception {
        Mutex mutex = new Mutex();
        Condition condition = mutex.newCondition();
        Thread t1 = new Thread(new SynchronizerTask(mutex, () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }), "线程1");
        Thread t2 = new Thread(new SynchronizerTask(mutex, () -> {
            try {
                condition.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }), "线程2");
        t1.start();
        Thread.sleep(10);
        t2.start();
    }


    static class Mutex implements Lock, Serializable {

        private final Synchronizer synchronizer;

        private static class Synchronizer extends AbstractQueuedSynchronizer {
            @Override
            protected boolean tryAcquire(int arg) {
                if (compareAndSetState(0, arg)) {
                    setExclusiveOwnerThread(Thread.currentThread());
                    System.out.println(Thread.currentThread().getName() + "获取到锁");
                    return true;
                }
                return false;
            }

            @Override
            protected boolean tryRelease(int arg) {
                if (getExclusiveOwnerThread() == Thread.currentThread() && getState() >= arg) {
                    setState(getState() - arg);
                    setExclusiveOwnerThread(null);
                    return true;
                }
                return false;
            }

            @Override
            protected boolean isHeldExclusively() {
                return getExclusiveOwnerThread() == Thread.currentThread();
            }

            final ConditionObject newCondition() {
                return new ConditionObject();
            }
        }

        public Mutex() {
            synchronizer = new Synchronizer();
        }

        @Override
        public void lock() {
            synchronizer.acquire(1);
        }

        @Override
        public void lockInterruptibly() throws InterruptedException {

        }

        @Override
        public boolean tryLock() {
            return false;
        }

        @Override
        public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
            return false;
        }

        @Override
        public void unlock() {
            synchronizer.release(1);
        }

        @Override
        public Condition newCondition() {
            return synchronizer.newCondition();
        }
    }

    private static class SynchronizerTask implements Runnable {
        private final Lock lock;
        private final Runnable task;

        public SynchronizerTask(Lock lock, Runnable task) {
            this.lock = lock;
            this.task = task;
        }

        @Override
        public void run() {
            lock.lock();
            try {
                task.run();
            } catch (Exception e) {
                System.out.println("执行任务发生异常了：" + e.getMessage());
            } finally {
                lock.unlock();
            }
        }
    }

    private static class CounterTask implements Runnable {
        private int count = 0;

        private final Mutex mutex;

        public CounterTask(Mutex mutex) {
            this.mutex = mutex;
        }

        @Override
        public void run() {
            mutex.lock();
            for (int i = 0; i < 10000; i++) {
                count++;
            }
            mutex.unlock();
        }

        public int getCounter() {
            return count;
        }
    }
}
