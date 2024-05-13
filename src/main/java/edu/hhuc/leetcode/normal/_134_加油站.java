package edu.hhuc.leetcode.normal;

/**
 * @program: leetcode
 * @ClassName _134_加油站
 * @description:
 * @author: gaoya
 * @create: 2023-01-12 16:32
 * @Version 1.0
 */
public class _134_加油站 {
    /**
     * 假如从1号站点出发最多可以到底5号站点，
     * 无法到达6号站点，那么从2，3，4，5号站点出发也无法到达6号站点，下一次尝试可以直接从6号站点开始
     */
    public int solution1(int[] gas, int[] cost) {
        // 从0号站点开始尝试
        int index = 0;
        while (index < gas.length) {
            int current = index;
            int rest = 0;
            // 以index为开始站点，计算是否可以回到起点
            while (current == index || current % gas.length != index) {
                rest += gas[current % gas.length];
                if (rest < cost[current % gas.length]) {
                    break;
                }
                rest = rest - cost[current % gas.length];
                current++;
            }
            if (current != index && current % gas.length == index) {
                return index;
            }
            // 很重要，跳过index至current之间的站点，因为以其中的任意站点都无法到达current+1号站点，
            // 因此之间从current+1号站点开始尝试
            index = current + 1;
        }
        // 遍历了一轮站点之后都无解，则返回-1
        return -1;
    }
}
