package maths;

public class M49 {
    public int nthUglyNumber(int n) {
        if (n == 0) {
            return 0;
        }
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        //第一个丑数为1
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
            dp[i] = Math.min(n2, Math.min(n3, n5));
            if (dp[i] == n2) {
                a++;
            }
            if (dp[i] == n3) {
                b++;
            }
            if (dp[i] == n5) {
                c++;
            }
        }
        return dp[n - 1];
    }
}
