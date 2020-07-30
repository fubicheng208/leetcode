package string;

import java.util.Arrays;

public class Solution151 {
    public String reverseWords(String s) {
        s = s.trim();
        String[] tmp = s.split("\\s+");
        StringBuilder sb = new StringBuilder("");
        //标识是否已出现连续空格
        for (int i = tmp.length - 1; i >= 0; i--) {
            sb.append(tmp[i]);
            sb.append(' ');
        }
        return sb.substring(0, sb.length() - 1);
    }


    public static void main(String[] args) {
        System.out.println(new Solution151().reverseWords("a good   example"));
    }
}
