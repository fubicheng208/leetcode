package dp.stock;

public class M123 {
/*    给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
    设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
    注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii*/

    //dp[i][k][0] 表示到当前第i天，最多进行k次交易，且当前不持有股票所获得的最大收益
    //dp[i][k][1] 表示到当前第i天，最多进行k次交易，且当前持有股票所获得的最大收益
    //买卖只计算一次交易
    // dp[i][k][0] = max{dp[i-1][k][0], dp[i-1][k][1] + prices[i] }
    // dp[i][k][1] = max{dp[i-1][k][1], dp[i-1][k-1][0] - prices[i]}
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int[][][] dp = new int[n][3][2];
        dp[0][1][0] = 0;
        dp[0][1][1] = -prices[0];
        dp[0][2][0] = 0;
        dp[0][2][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][2][0] = Math.max(dp[i - 1][2][0], dp[i - 1][2][1] + prices[i]);
            dp[i][2][1] = Math.max(dp[i - 1][2][1], dp[i - 1][1][0] - prices[i]);
            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][1][1] + prices[i]);
            dp[i][1][1] = Math.max(dp[i - 1][1][1], dp[i - 1][0][0] - prices[i]);
        }
        return dp[n - 1][2][0];
    }
}
