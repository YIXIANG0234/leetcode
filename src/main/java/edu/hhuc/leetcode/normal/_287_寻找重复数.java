package edu.hhuc.leetcode.normal;

/**
 * @author guwanghuai
 * @version 1.0
 * @project leetcode
 * @description
 * @date 2024/7/22 16:54:57
 */
public class _287_寻找重复数 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 3, 4, 5, 2};
        _287_寻找重复数 instance = new _287_寻找重复数();
        System.out.println(instance.solution3(nums));
    }

    /**
     * 借助额外的hash数组，将数字放到对应的位置
     *
     * @param nums
     * @return
     */
    public int solution1(int[] nums) {
        int[] hash = new int[nums.length + 1];
        for (int num : nums) {
            if (hash[num] != 0) {
                return num;
            }
            hash[num] = num;
        }
        return -1;
    }

    /**
     * 暴力查找
     *
     * @param nums
     * @return
     */
    public int solution2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }
        return -1;
    }

    /**
     * 原地hash，将数字num放到数组num-1的下标的位置，换言之：num[i]存放的数字是i+1
     *
     * @param nums
     * @return
     */
    public int solution3(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            // nums[i] < i + 1表示是之前的位置，之前的位置是处理过的，现在又出现了，表示该数字重复了
            if (nums[i] < i + 1) {
                return nums[i];
            }
            // 如果当前位置不应该放这个数，则一直交换到对应的位置为止
            while (nums[i] != i + 1) {
                int targetIndex = nums[i] - 1;
                // 当前的位置和要交换的目标位置值相同，死循环了，说明该数字是重复的
                if (nums[i] == nums[targetIndex]) {
                    return nums[i];
                }
                int temp = nums[targetIndex];
                nums[targetIndex] = nums[i];
                nums[i] = temp;
            }
        }
        return -1;
    }

    /**
     * 二分查找
     *
     * @param nums
     * @return
     */
    public int solution4(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            int cnt = 0;
            for (int v : nums) {
                if (v <= mid) {
                    ++cnt;
                }
            }
            if (cnt > mid) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    /**
     * 快慢指针，该问题的实质和和_142_环形链表II一样
     *
     * @param nums
     * @return
     */
    public int solution5(int[] nums) {
        int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
