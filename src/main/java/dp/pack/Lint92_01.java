package dp.pack;

public class Lint92_01 {
/*    在n个物品中挑选若干物品装入背包，最多能装多满？
    假设背包的大小为m，每个物品的大小为A[i]*/

    public int backPack(int m, int[] A) {
        int dp[][] = new int[A.length + 1][m + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (A[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - A[i - 1]] + A[i - 1]);
                }
            }
        }
        return dp[A.length][m];
    }

    public int backPackV2(int m, int[] A) {
        int dp[] = new int[m + 1];
        for (int num : A) {
            //1. 从后往前，因为要用到上一轮的数据
            //2. j>=num, 因为j < num时，这个物品必然无法放入背包
            for (int j = m; j >= m; j--) {
                dp[j] = Math.max(dp[j], dp[j - num] + num);
            }
        }
        return dp[m];
    }

}
