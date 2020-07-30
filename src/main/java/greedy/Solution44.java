package greedy;

/*给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。

        '?' 可以匹配任何单个字符。
        '*' 可以匹配任意字符串（包括空字符串）。
        两个字符串完全匹配才算匹配成功。

        说明:

        s 可能为空，且只包含从 a-z 的小写字母。
        p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。*/


public class Solution44 {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] dp = new boolean[n + 1][m + 1];//字符串为空时下标为0，所以n+1, m+1
        dp[0][0] = true;
        for (int j = 1; j <= m; j++) {
            if (p.charAt(j - 1) == '*')
                dp[0][j] = dp[0][j - 1];//s:空； p:**** dp[0][0]->dp[0][4] = true // s:空 p:*a dp[0][0]->dp[0][1]:true, dp[0][2]:false
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?')
                    dp[i][j] = dp[i - 1][j - 1];
                else if (p.charAt(j - 1) == '*')
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
            }
        }
        return dp[n][m];

    }
}
