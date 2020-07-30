package dp;

public class Solution28KMP {
//    实现 strStr() 函数。
//    给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
//
//    示例 1:
//    输入: haystack = "hello", needle = "ll"
//    输出: 2

    class KMP {
        public int[][] dp;
        public String pat;

        public KMP(String pat) {
            this.pat = pat;
            int M = pat.length();
            dp = new int[M][256];

            dp[0][pat.charAt(0)] = 1;
            int X = 0;
            for (int j = 1; j < M; j++) {
                for (int c = 0; c < 256; c++) {
                    dp[j][c] = dp[X][c];
                }
                dp[j][pat.charAt(j)] = j + 1;
                X = dp[X][pat.charAt(j)];
            }
        }

        public int search(String haystack) {
            int M = pat.length();
            int j = 0;
            for (int i = 0; i < haystack.length(); i++) {
                j = dp[j][haystack.charAt(i)];
                if (j == M)
                    return i - M + 1;
            }
            return -1;

        }

    }


    public int strStr(String haystack, String needle) {
        if (needle == null || needle.isEmpty())
            return 0;
        if (haystack == null)
            return -1;
        KMP k = new KMP(needle);
        return k.search(haystack);
    }
}
