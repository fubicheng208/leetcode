package back_tracking;

import java.util.HashSet;
import java.util.Set;

public class M38 {
/*    输入一个字符串，打印出该字符串中字符的所有排列。
    你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。*/
    Set<String> res = new HashSet<>();
    int[] f;
    public String[] permutation(String s) {
        if(s == null || s.length() == 0){
            return null;
        }
        int n = s.length();
        f = new int[n];
        helper("", s);
        return res.toArray(new String[res.size()]);
    }

    public void helper(String now, String s){
        if(now.length() == f.length){
            res.add(now);
            return;
        }
        for(int i = 0; i < f.length; i++){
            if(f[i] == 0){
                f[i] = 1;
                helper(now + s.charAt(i), s);
                f[i] = 0;
            }
        }
    }
}
