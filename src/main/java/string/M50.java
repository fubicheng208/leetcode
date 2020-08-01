package string;

import java.util.LinkedHashMap;
import java.util.Map;

public class M50 {

/*    在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
    示例:
    s = "abaccdeff"
    返回 "b"
    s = ""
    返回 " "*/

    public static char firstUniqChar(String s) {
        LinkedHashMap<Character, Boolean> lhm = new LinkedHashMap<>();
        for(Character c : s.toCharArray()){
            lhm.put(c, !lhm.containsKey(c));
        }
        for(Map.Entry<Character, Boolean> entry : lhm.entrySet()){
            if(entry.getValue()) return entry.getKey();
        }
        return ' ';
    }
}
