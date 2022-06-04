package edu.hhuc.leetcode.normal;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class _077_组合 {
    public static void main(String[] args) {
        _077_组合 instance = new _077_组合();
        System.out.println(instance.solution1(5, 2));
    }

    /**
     * 利用本题元素有序的特点
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> solution1(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrace(0, k, new ArrayList<>(), result, IntStream.range(1,n+1).toArray(), n, new boolean[n],0);
        return result;
    }

    /**
     *
     * @param count 目前已经选取到的元素个数，count=k时，表示选到了一个组合
     * @param k 需要选取k个元素
     * @param combineList 一个组合
     * @param result 结果集
     * @param nums 元素表
     * @param n 元素表的个数
     * @param judge 元素是否被使用过
     * @param currentIndex 本次选取元素的起始位置
     */
    public void backtrace(int count, int k, List<Integer> combineList, List<List<Integer>> result, int[] nums, int n, boolean[] judge, int currentIndex) {
        if (count == k) {
            result.add(new ArrayList<>(combineList));
            return;
        }
        for (int i=currentIndex;i<n;i++){
            if (judge[i]){
                continue;
            }
            combineList.add(nums[i]);
            judge[i] = true;
            backtrace(count+1, k, combineList,result,nums,n,judge,i+1);
            judge[i] = false;
            combineList.remove(count);
        }
    }
}
