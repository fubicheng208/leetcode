package sliding_window;

import java.util.HashSet;
import java.util.Set;

public class M48 {
    /*    请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
        示例 1:
        输入: "abcabcbb"
        输出: 3
        解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。*/
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int res = 0, r = -1;
        int len = s.length();
        for (int l = 0; l < len; l++) {
            if (l != 0) {
                set.remove(s.charAt(l - 1));
            }
            //增大右窗口直到出现重复
            while (r + 1 < len && !set.contains(s.charAt(r + 1))) {
                set.add(s.charAt(r + 1));
                r++;
            }
            res = Math.max(res, set.size());
        }
        return res;
    }
}
