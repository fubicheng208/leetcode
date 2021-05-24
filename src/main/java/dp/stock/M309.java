package dp.stock;

public class M309 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        if (n == 1) {
            return 0;
        }
        for (int i = 1; i < n; i++) {
            //昨天买今天可以卖
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            //昨天卖了，今天不能买，今天只能买前天及以前的
            //第1，2天之前肯定不可能完全进行过一次交易，即只能是没有交易过的情况
            dp[i][1] = Math.max(dp[i - 1][1], (i < 2 ? 0 : dp[i - 2][0]) - prices[i]);
        }
        return dp[n - 1][0];
    }
}
