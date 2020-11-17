package dp.stock;

public class M63 {

    // 通用公式：
    // dp[i][k][0] = Math.max(dp[i-1][k][0],dp[i-1][k][1] + prices[i])
    // dp[i][k][1] = Math.max(dp[i-1][k][1],dp[i-1][k-1][0] - prices[i])

    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        //第0天买入股票
        dp[0][1] = -prices[0];
        for(int i = 1; i < n; i++){
            //保持前一天未持有股票的状态或者前一天有股票，今天卖出股票
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + prices[i]);
            //保持前一天持有股票的状态不变或者前一天没有股票，今天买入股票
            //因为只能交易一次，所以这次买之前，收益肯定为0
            dp[i][1] = Math.max(dp[i-1][1], -prices[i]);
        }
        //已卖出股票肯定比持有股票收益高，即dp[n-1][0] > dp[n-1][1];
        return dp[n-1][0];
    }
}
