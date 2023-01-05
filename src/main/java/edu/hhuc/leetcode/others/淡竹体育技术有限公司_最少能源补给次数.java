package edu.hhuc.leetcode.others;

/**
 * 4 星际战舰从基地前往巨蟹星营救科学家，巨蟹星在离基地distance光年远处，从基地前往巨蟹星的直线路径沿途有能源补给站，
 * 每个station[i]代表一个能源补给站，它位于基地前往巨蟹星的直线路径的station[i][0]光年处，并且有station[i][1]尔格能源(尔格是能源单位)。
 * 星际战舰可以储备无限大的能源，其从基地出发时拥有initialEnergy尔格能源，它每行驶1光年就会用掉1尔格能源。当星际战舰到达能源补给站时，
 * 它可能停下来补给能源，将该能源补给站的所有能源从能源补给站转移到星际战舰中。
 * 为了用最短时间到达目的地，星际战舰要尽可能少的进能源补给站，求星际战舰沿途进能源补给站的最少次数是多少？
 * 注意：如果星际战舰到达能源补给站时剩余能源为0，它仍然可以在那里补给能源。如果星际战舰到达目的地时剩余能源为 0，亦认为它已经到达目的地。
 * 用Java/JS/TS/C++语言写一个函数实现。
 * 输入三个参数：distance, initialEnergy, stations[][]二维数组
 * 输出：进能源补给站次数。如果星际战舰无法到达目的地，则输出-1。
 * 例1输入：distance= 100, initialEnergy= 100, stations = []， 输出：0
 * 解释：可以在不进能源补给站的情况下到达目的地。
 * 例2输入：distance= 100, initialEnergy=50, stations = [[100,100]]，输出：-1
 * 解释：无法抵达目的地，甚至无法到达第一个能源补给站。
 * 示例3输入：distance= 100, initialEnergy= 10, stations =[[10,60],[20,30],[30,30],[60,40]]，输出：2
 * 解释：到距基地 10 光年处的能源补给站，将能源从0尔格加到60尔格。到60光年处的能源补给站(消耗50尔格能源)，并将能源从10尔格加到50尔格。2次进站然后抵达目的地。
 */
public class 淡竹体育技术有限公司_最少能源补给次数 {

    public static void main(String[] args) {
    }

    public static int solution1(int distance, int initialEnergy, int[][] stations) {
//        int[] dp = new int[stations.length];
        int count = 0;
        for (int i = 0; i < stations.length; i++) {
            int stationDistance = i == 0 ? stations[i][0] : stations[i][0] - stations[i - 1][0];
            if (initialEnergy < stationDistance) {
                return -1;
            } else if (initialEnergy == stationDistance) {
                if (i == stations.length - 1) {
                    return count;
                }
                // 到达该站点时，刚好没有能源了，必须要加能源
                initialEnergy = initialEnergy - stationDistance + stations[i][1];
                count++;
            } else {
                // 到底该站点时，还有剩余能源，需不需要加呢？
                // 已经到底终点
                if (i == stations.length - 1) {
                    return count;
                }
                if (initialEnergy < (stations[i + 1][0] - stations[i][0])) {
                    initialEnergy = initialEnergy - stationDistance + stations[i][1];
                }
            }

        }
        return count;
    }

    /**
     * 尝试用动态规划求解
     *
     * @param distance
     * @param initialEnergy
     * @param stations
     * @return
     */
    public static int solution2(int distance, int initialEnergy, int[][] stations) {
        // 代表到底第i个能源站时，需要加能源的次数
        int[] dp = new int[stations.length];
        if (initialEnergy < stations[0][0]) {
            return -1;
        }
        for (int i = 0; i < stations.length; i++) {
            for (int j = 0; j < i; j++) {
                int stationDistance = stations[i][0] - stations[j][0];
            }
        }

        return dp[stations.length - 1];
    }
}
