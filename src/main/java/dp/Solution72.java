package dp;

public class Solution72 {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        if (m == 0 || n == 0)
            return m + n;
        int dp[][] = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++)
            dp[i][0] = i;
        for (int j = 0; j < n + 1; j++)
            dp[0][j] = j;
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                int k = word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1;
                dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1), dp[i - 1][j - 1] + k);
            }
        }

        return dp[m][n];
    }
}
