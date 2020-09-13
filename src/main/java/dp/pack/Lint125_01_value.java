package dp.pack;

public class Lint125_01_value {

    /*有 n 个物品和一个大小为 m 的背包. 给定数组 A 表示每个物品的大小和数组 V 表示每个物品的价值.
    问最多能装入背包的总价值是多大?
    输入: m = 10, A = [2, 3, 5, 7], V = [1, 5, 2, 4]
    输出: 9
    解释: 装入 A[1] 和 A[3] 可以得到最大价值, V[1] + V[3] = 9*/

    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @param V: Given n items with value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int[] V) {
        //A[i][j] 前i个物体放入j的背包所能获得的最大价值
        int dp[][] = new int[A.length + 1][m + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                //该物体放不进去，则肯定不放
                if (A[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - A[i - 1]] + V[i - 1]);
                }
            }
        }
        return dp[A.length][m];
    }

    public int backPackIIV2(int m, int[] A, int[] V) {
        int[] dp = new int[m + 1];
        for (int i = 0; i < A.length; i++) {
            for(int j = m; j >= A[i]; j--){
                //放：背包容量为j-A[i]时的最大价值+当前物品价值
                //不放：前i-1个物体背包容量为j时的最大价值
                dp[j] = Math.max(dp[j], dp[j-A[i]] + V[i]);
            }
        }
        return dp[m];
    }
}
