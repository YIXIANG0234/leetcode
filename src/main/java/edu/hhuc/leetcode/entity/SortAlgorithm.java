package edu.hhuc.leetcode.entity;

import java.util.*;
import java.util.stream.IntStream;

public class SortAlgorithm {
    public static void main(String[] args) {
        int[] nums = generateRandomNums(30);
        int[] origin = Arrays.copyOf(nums, nums.length);

        System.out.println("数组排序前：");
        System.out.println(Arrays.toString(nums));
        System.out.println("复制了随机数组：");
        System.out.println(Arrays.toString(origin));

        System.out.println("数组排序后：");
        // 这里更换排序算法
        radixSort(nums);
        System.out.println(Arrays.toString(nums));

        System.out.println("调用系统函数排序后：");
        Arrays.sort(origin);
        System.out.println(Arrays.toString(origin));

        System.out.println("数组排序结果验证：" + verify(nums));
    }


    /**
     * 冒泡排序
     * 共进行n-1轮排序，每轮排序将相邻两个元素进行比较，较大的元素后移，这样第一轮下来后，数组的最后一个元素就是数组中最大的元素了
     * 然后进行第二轮，直到所有元素有序
     *
     * @param nums
     */
    public static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 选择排序
     * 每次从未排序的序列中选择一个最小的元素放在已排序序列的最后，依次进行，知道所以元素有序
     *
     * @param nums
     */
    public static void selectSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                int temp = nums[i];
                nums[i] = nums[minIndex];
                nums[minIndex] = temp;
            }
        }
    }

    /**
     * 插入排序
     * 1.把待排序的数组分成已排序和未排序两部分，初始的时候把第一个元素认为是已排好序的
     * 2.从第二个元素开始，在已排好序的子数组中寻找到该元素合适的位置并插入该位置
     * 3.重复上述过程直到最后一个元素被插入有序子数组中
     *
     * @param nums
     */
    public static void insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; ++i) {
            int value = nums[i];
            int position = i;
            while (position > 0 && nums[position - 1] > value) {
                nums[position] = nums[position - 1];
                position--;
            }
            nums[position] = value;
        }
    }

    /**
     * 归并排序
     * 递归的实现方式
     *
     * @param nums
     */
    public static void mergeSort(int[] nums) {
        internalMergeSort(nums, 0, nums.length - 1);
    }

    /**
     * 快速排序
     *
     * @param nums
     */
    public static void quickSort(int[] nums) {
        internalQuickSort(nums, 0, nums.length - 1);
    }

    /**
     * 堆排序
     * 堆是一棵完全二叉树，分为大顶堆和小顶堆
     *
     * @param nums
     */
    public static void heapSort(int[] nums) {
        buildMaxHeap(nums);
        for (int i = nums.length - 1; i >= 0; i--) {
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;

            adjustHeap(nums, i, 0);
        }
    }

    /**
     * 希尔排序
     *
     * @param nums
     */
    public static void shellSort(int[] nums) {
        for (int delta = nums.length / 2; delta >= 1; delta /= 2) {
            for (int i = 0; i < nums.length; i += delta) {
                for (int j = i; j > 0; j -= delta) {
                    if (nums[j] < nums[j - delta]) {
                        int temp = nums[j];
                        nums[j] = nums[j - delta];
                        nums[j - delta] = temp;
                    }
                }
            }
        }
    }

    /**
     * 计数排序
     *
     * @param nums
     */
    public static void countSort(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        // 找待排序数组的范围
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        // 计数数组
        int countSize = max - min + 1;
        int[] count = new int[countSize];
        // 记录每个值出现的次数
        for (int i = 0; i < nums.length; i++) {
            int index = nums[i] - min;
            count[index]++;
        }
        int i = 0;
        int index = 0;
        // 将计数数组的值还原到目标数组中
        while (i < countSize) {
            if (count[i] == 0) {
                i++;
                continue;
            }
            nums[index] = i + min;
            count[i]--;
            index++;
        }
    }

    /**
     * 桶排序
     *
     * @param nums
     */
    public static void bucketSort(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        // 桶的个数
        int bucketNum = (max - min) / nums.length + 1;
        // 初始化桶
        List<List<Integer>> buckets = new ArrayList<>(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            buckets.add(new ArrayList<>());
        }
        for (int i = 0; i < nums.length; i++) {
            int bucketIndex = (nums[i] - min) / nums.length;
            buckets.get(bucketIndex).add(nums[i]);
        }
        buckets.forEach(x -> Collections.sort(x));
        int index = 0;
        for (int i = 0; i < bucketNum; i++) {
            List<Integer> bucket = buckets.get(i);
            for (int j = 0; j < bucket.size(); j++) {
                nums[index++] = bucket.get(j);
            }
        }
    }

    /**
     * 基数排序
     * @param nums
     */
    public static void radixSort(int[] nums) {
        int max = nums[0];
        for (int num : nums) {
            max = Math.max(max, num);
        }
        // 10个桶，0-9
        List<List<Integer>> buckets = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            buckets.add(new ArrayList<>());
        }
        int exp = 1;
        // 循环处理不同的位，从各位开始
        while (max / exp > 0) {
            for (int i = 0; i < nums.length; i++) {
                // 计算当前需要处理的最低位
                int bucketIndex = (nums[i] / exp) % 10;
                buckets.get(bucketIndex).add(nums[i]);
            }
            // 对每个桶中的元素排序
            buckets.forEach(Collections::sort);
            int index = 0;
            // 将当前桶中的元素复制到原数组中，准备进行下一轮排序
            for (int i = 0; i < buckets.size(); i++) {
                List<Integer> bucket = buckets.get(i);
                for (int j = 0; j < bucket.size(); j++) {
                    nums[index++] = bucket.get(j);
                }
                bucket.clear();
            }
            // 处理下一位
            exp = exp * 10;
        }
    }

    private static void buildMaxHeap(int[] nums) {
        int mid = nums.length >> 1;
        // i = mid时，是堆的倒数第二层
        for (int i = mid; i >= 0; i--) {
            adjustHeap(nums, nums.length, i);
        }
    }

    private static void adjustHeap(int[] nums, int size, int parent) {
        int left = (parent << 1) + 1;
        int right = (parent << 1) + 2;
        int largest = parent;
        if (left < size && nums[left] > nums[largest]) {
            largest = left;
        }
        if (right < size && nums[right] > nums[largest]) {
            largest = right;
        }
        if (parent != largest) {
            int temp = nums[parent];
            nums[parent] = nums[largest];
            nums[largest] = temp;
            adjustHeap(nums, size, largest);
        }
    }

    private static void internalQuickSort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int pivot = partition(nums, low, high);
        internalQuickSort(nums, low, pivot - 1);
        internalQuickSort(nums, pivot + 1, high);
    }

    private static int partition(int[] nums, int low, int high) {
        int pivot = nums[low];
        while (low < high) {
            while (low < high && nums[high] >= pivot) {
                high--;
            }
            nums[low] = nums[high];
            while (low < high && nums[low] <= pivot) {
                low++;
            }
            nums[high] = nums[low];
        }
        nums[low] = pivot;
        return low;
    }

    private static void internalMergeSort(int[] nums, int low, int high) {
        if (low < high) {
            int middle = (low + high) / 2;
            internalMergeSort(nums, low, middle);
            internalMergeSort(nums, middle + 1, high);
            mergeSortedArray(nums, low, middle, high);
        }
    }

    private static void mergeSortedArray(int nums[], int low, int middle, int high) {
        // 临时数组
        int temp[] = new int[high - low + 1];
        int i = low;
        int j = middle + 1;
        int k = 0;
        while (i <= middle && j <= high) {
            if (nums[i] <= nums[j]) {
                temp[k] = nums[i];
                i++;
            } else {
                temp[k] = nums[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            temp[k] = nums[i];
            i++;
            k++;
        }
        while (j <= high) {
            temp[k] = nums[j];
            j++;
            k++;
        }
        for (int l = 0; l < k; l++) {
            nums[low + l] = temp[l];
        }
    }

    public static int[] generateRandomNums(int quantity) {
        Random random = new Random();
        return IntStream.generate(() -> random.nextInt(100)).limit(quantity).toArray();
    }

    public static boolean verify(int[] nums) {
        int i = 0;
        while (i < nums.length - 1) {
            if (nums[i] > nums[i + 1]) {
                return false;
            }
            i++;
        }
        return true;
    }
}
