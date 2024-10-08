package edu.hhuc.leetcode.entity;

import java.util.Arrays;

/**
 * @author guwanghuai
 * @version 1.0
 * @project leetcode
 * @description
 * @date 2024/5/19 11:21:35
 */
public class Heap {
    private final boolean maxHeap;
    private int length;
    /**
     * 由于堆是一颗完全二叉树，使用数组来存储数据，避免额外存储指针带来的开销
     * 数据从下标1开始存储，即根节点存储在下标为0的位置，则有一下公式
     * 1.任意节点的下标为i，其左节点的下标为：2*i+1
     * 2.任意节点的下标为i，其右节点的下标为：2*i+2
     * 3.任意节点的下标为i，其父节点的下标为：(i-1)/2
     */
    private int[] data;
    // 当前存储数据的位置
    private int index = 0;

    public Heap(boolean maxHeap, int length) {
        this.maxHeap = maxHeap;
        this.length = length;
        this.data = new int[length];
    }

    public static Heap newMaxHeap(int length) {
        return new Heap(true, length);
    }

    public static Heap newMinHeap(int length) {
        return new Heap(false, length);
    }

    /**
     * 往堆中添加元素，当添加元素之后不满足堆的条件，则自下而上的调整堆
     *
     * @param num 要添加的元素
     */
    public void add(int num) {
        resize();
        int parent = (index - 1) / 2;
        data[index] = num;
        int currentIndex = index;
        while (maxHeap ? num > data[parent] : num < data[parent]) {
            int temp = data[parent];
            data[parent] = data[currentIndex];
            data[currentIndex] = temp;
            currentIndex = parent;
            parent = (parent - 1) / 2;
        }
        index++;
    }

    /**
     * 查找堆中的元素，找到并返回下标，否则返回-1
     *
     * @param num 查找的元素
     * @return 元素所在下标
     */
    public int find(int num) {
        return find(num, 0);
    }

    /**
     * 删除堆顶元素，并将最后一个元素并在堆顶，然后进行自上而下的调整
     *
     * @return 堆顶元素
     */
    public int removeTop() {
        if (index == 0) {
            return -1;
        }
        int result = data[0];
        // 把堆顶元素删除，并将最后一个元素放到堆顶
        data[0] = data[index - 1];
        index--;
        // 调整堆
        adjustHeap(index, 0);
        return result;
    }

    private void adjustHeap(int bound, int parent) {
        int topIndex = parent;
        while (true) {
            int left = parent * 2 + 1;
            int right = parent * 2 + 2;

            if (left < bound && (maxHeap ? data[left] > data[parent] : data[left] < data[parent])) {
                topIndex = left;
            }
            if (right < bound && (maxHeap ? data[right] > data[topIndex] : data[right] < data[topIndex])) {
                topIndex = right;
            }
            if (topIndex == parent) {
                break;
            }
            swap(data, topIndex, parent);
            parent = topIndex;
        }
    }

    private int find(int num, int root) {
        // 防止越界
        if (root >= index) {
            return -1;
        }
        if (data[root] == num) {
            return root;
        }
        // 大顶堆：要查找的值比当前节点还大，证明不在堆中；小顶堆：要查找的值比当前节点还小，证明不在堆中
        if (maxHeap ? num > data[root] : num < data[root]) {
            return -1;
        }
        int left = find(num, root * 2 + 1);
        if (left != -1) {
            return left;
        }
        int right = find(num, root * 2 + 2);
        if (right != -1) {
            return right;
        }
        return -1;
    }

    public int[] getData() {
        return Arrays.copyOf(this.data, index);
    }

    /**
     * 扩容
     */
    private void resize() {
        if (index >= length) {
            this.length = this.length * 2;
            this.data = Arrays.copyOf(this.data, length);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] data = new int[]{33, 27, 21, 16, 13, 15, 9, 5, 6, 7, 8, 1, 2};
        Heap maxHeap = Heap.newMaxHeap(data.length);
        // Heap maxHeap = Heap.newMinHeap(data.length);
        for (int i = 0; i < data.length; i++) {
            maxHeap.add(data[i]);
        }
        TreeNodeUtils.prettyPrintTree(TreeNodeUtils.buildTree(maxHeap.getData()));
        maxHeap.add(8);
        TreeNodeUtils.prettyPrintTree(TreeNodeUtils.buildTree(maxHeap.getData()));
        System.out.println(maxHeap.find(28));
        System.out.println(maxHeap.removeTop());
        TreeNodeUtils.prettyPrintTree(TreeNodeUtils.buildTree(maxHeap.getData()));
    }

}
