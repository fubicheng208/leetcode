package dp.pack;

public class M14_2 {
    public int cuttingRope(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        //用1-i的切分方法，切分长度为j的绳子，能获得最大的乘积
        for(int i = 1; i < n; i++){
            for(int j = i; j <= n; j++){
                dp[j] = Math.max(dp[j] % 1000000007, (int)(dp[j - i] * i % 1000000007));
            }
        }
        return dp[n];
    }
}
