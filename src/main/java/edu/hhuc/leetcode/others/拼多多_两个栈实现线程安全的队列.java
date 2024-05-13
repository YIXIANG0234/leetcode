package edu.hhuc.leetcode.others;

import java.util.Objects;
import java.util.Stack;

/**
 * @program: leetcode
 * @ClassName 拼多多_两个栈实现线程安全的队列
 * @description: 使用两个栈实现线程安全的队列，要求效率要尽可能高
 * @author: gaoya
 * @create: 2023-02-22 17:11
 * @Version 1.0
 */
public class 拼多多_两个栈实现线程安全的队列 {
    /**
     * 两个栈，分别模拟队列的入队和出队
     */
    private Stack<Integer> pushStack;
    private Stack<Integer> popStack;
    /**
     * 两把锁，控制入队和出队，提高并发度
     */
    private Object pushLock = new Object();
    private Object popLock = new Object();

    public 拼多多_两个栈实现线程安全的队列() {
        this.pushStack = new Stack<>();
        this.popStack = new Stack<>();
    }

    public void add(int num) {
        // 入队加锁
        synchronized (pushLock) {
            pushStack.push(num);
        }
    }

    public Integer remove() {
        // 出队加锁
        synchronized (popLock) {
            if (popStack.isEmpty()) {
                // 当出队的栈中没有元素，需要从入对的栈中取元素时，需要先获取入队的锁
                synchronized (pushLock) {
                    while (!pushStack.isEmpty()) {
                        popStack.push(pushStack.pop());
                    }
                }
            }
            return popStack.isEmpty() ? null : popStack.pop();
        }
    }

    /**
     * 两个线程进行测试，一个生产者，往队列中写数据，一个消费者从队列中读取数据
     * 如果队列是线程安全的，则测试结果为控制台以自然数的顺序进行输出
     * @param args
     */
    public static void main(String[] args) {
        拼多多_两个栈实现线程安全的队列 instance = new 拼多多_两个栈实现线程安全的队列();
        Runnable producer = () -> {
            for (int i = 0; i < 1000; i++) {
                instance.add(i);
            }
        };

        Runnable consumer = () -> {
            while (true) {
                Integer num = instance.remove();
                if (Objects.nonNull(num)) {
                    System.out.println(num);
                }
            }
        };

        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
