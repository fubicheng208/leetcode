package dp.pack;

public class Lint440_full_value {
/*    Given n kind of items with size Ai and value Vi( each item has an infinite number available) and a backpack with size m. What’s the maximum value can you put into the backpack?
    Notice
    You cannot divide item into small pieces and the total size of items you choose should smaller or equal to m.
            Example
    Given 4 items with size [2, 3, 5, 7] and value [1, 5, 2, 4], and a backpack with size 10. The maximum value is 15.*/


    public int backPackIII(int m, int[] A, int[] V) {
        int[][] dp = new int[A.length + 1][m + 1];
        for (int i = 1; i <= A.length; i++) {
            for (int j = A[i - 1]; j <= m; j++) {
                for (int k = 0; k * A[i - 1] <= m; k++) {
                    //如果当前的容量可以放k个
                    if (j >= k * A[i - 1]) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - k * A[i - 1]] + k * V[i - 1]);
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }
        return dp[A.length][m];
    }

    public int backPackIIIV2(int m, int[] A, int[] V) {
        int[][] dp = new int[A.length + 1][m + 1];
        for (int i = 1; i <= A.length; i++) {
            for (int j = 0; j <= m; j++) {
                if (A[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - A[i - 1]] + V[i - 1]);
                }
            }
        }
        return dp[A.length][m];
    }

    public int backPackIIIV3(int m, int[] A, int[] V) {
        int[] dp = new int[m + 1];
        for (int i = 0; i < A.length; i++) {
            for (int j = A[i]; j <= m; j++) {
                dp[j] = Math.max(dp[j], dp[j - A[i]] + V[i]);
            }
        }
        return dp[m];
    }
}