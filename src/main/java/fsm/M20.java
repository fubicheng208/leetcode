package fsm;

import java.util.HashMap;
import java.util.Map;

public class M20 {
    /*    请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
        例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"0123"都表示数值，
        但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof*/
    //参考题解：https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof/solution/mian-shi-ti-20-biao-shi-shu-zhi-de-zi-fu-chuan-y-2/
    public boolean isNumber(String s) {
        Map[] states = {
                new HashMap<Character, Integer>() {{
                    put(' ', 0);
                    put('s', 1);
                    put('d', 2);
                    put('.', 4);
                }},
                new HashMap<Character, Integer>() {{
                    put('d', 2);
                    put('.', 4);
                }},
                new HashMap<Character, Integer>() {{
                    put('d', 2);
                    put('.', 3);
                    put('e', 5);
                    put(' ', 8);
                }},
                new HashMap<Character, Integer>() {{
                    put('d', 3);
                    put('e', 5);
                    put(' ', 8);
                }},
                new HashMap<Character, Integer>() {{
                    put('d', 3);
                }},
                new HashMap<Character, Integer>() {{
                    put('d', 7);
                    put('s', 6);
                }},
                new HashMap<Character, Integer>() {{
                    put('d', 7);
                }},
                new HashMap<Character, Integer>() {{
                    put('d', 7);
                    put(' ', 8);
                }},
                new HashMap<Character, Integer>() {{
                    put(' ', 8);
                }}
        };
        int p = 0;
        char t;
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                t = 'd';
            } else if (c == '+' || c == '-') {
                t = 's';
            } else if (c == 'e' || c == 'E') {
                t = 'e';
            } else if (c == ' ') {
                t = ' ';
            } else if (c == '.') {
                t = '.';
            } else {
                t = '?';
            }
            //如果当前状态无法转移到下一状态则返回false,
            if (!states[p].containsKey(t)) {
                return false;
            }
            p = (int) states[p].get(t);
        }
        return p == 2 || p == 3 || p == 7 || p == 8;
    }
}
