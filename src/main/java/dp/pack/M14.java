package dp.pack;

public class M14 {
/*    给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
    每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1]
    可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/jian-sheng-zi-lcof*/

    //完全背包问题，物品大小为1,2,...,n-1
    public int cuttingRope(int n) {        int[] dp = new int[n+1];
        dp[0] = 1;
        //用1-i的切分方法，切分长度为j的绳子，能获得最大的乘积
        for(int i = 1; i < n; i++){
            for(int j = i; j <= n; j++){
                dp[j] = Math.max(dp[j], dp[j - i] * i);
            }
        }
        return dp[n];

    }
}
