package sliding_window;

import java.util.HashSet;
import java.util.Set;

public class Solution3 {
//    给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//
//    示例 1:
//
//    输入: "abcabcbb"
//    输出: 3
//    解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int ans = 0, rk = -1;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (i != 0)
                set.remove(s.charAt(i - 1));
            while (rk + 1 < n && !set.contains(s.charAt(rk + 1))) {
                set.add(s.charAt(rk + 1));
                rk++;
            }
            ans = Math.max(ans, rk - i + 1);
            if (rk + 1 == n)
                return ans;
        }
        return ans;
    }
}
