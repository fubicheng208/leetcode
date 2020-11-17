package bishi.tx;

import java.util.HashSet;

public class Main {
    //给定m个不重复字符[a,b,c]，以及一个长度为n的字符串 (如：tbbacbctsafsg)，
    // 问能否在这个字符串中找到一个长度为m的连续子串。
    // 要求子串由m个字符组成，顺序不要求 返回 bac
    public static void main(String[] args) {
        char[] cs = new char[]{'a', 'b', 'c'};
        String s = "tbbacbctsafsg";
        String res = findStr(cs, s);
        System.out.println(res);
    }

    public static String findStr(char[] cs, String s){
        String res = "";
        HashSet<Character> set = new HashSet<>();
        for(Character c : cs){
            set.add(c);
        }
        for(int i = 0; i < s.length(); i++){
            HashSet<Character> tmp = new HashSet<>();
            tmp.addAll(set);
            for(int j = i; j < i + cs.length; j++){
                if(tmp.contains(s.charAt(j))){
                    tmp.remove(s.charAt(j));
                }
            }
            if(tmp.size() == 0){
                res = s.substring(i, i + cs.length);
                break;
            }
        }
        return res;
    }

}
