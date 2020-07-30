package heap;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    static final String urlVal = "(https?|ftp|file)://[-A-Za-z0-9+&@#/%?=~_|!:,.;]+[-A-Za-z0-9+&@#/%=~_|]";

    public static boolean matchUrl(String url, String pattern) {
//"https://m.taobao.com/test1/index.html"和"https://m.taobao.com/test1/test2/index.html"
//和"https://m.taobao.com/index.html"与模式"https://m.taobao.com/*/index.html"匹配
// ，但是"https://m.taobao.com/test1/test2/index.html"与模式"https://m.taobao.com/test2/*/index.html"不匹配
        //问题转化为
// "m.taobao.com/test1"和"m.taobao.com/test1/test2"
// 和"m.taobao.com"与模式"m.taobao.com/*"匹配
//# ，但是"m.taobao.com/test1/test2"与模式"m.taobao.com/test2/*"不匹配

        //检验url是否合法
        Pattern p = Pattern.compile(urlVal);
        Matcher matcher = p.matcher(url);
        if (!matcher.matches())
            return false;
        //检查模式串是否含有*
        if (!pattern.contains("*"))
            return pattern.equals(url);
        //转化为子问题去除协议和html，仅留下路径
        url = url.replaceAll("https://", "");
        url = url.replaceAll("/*html", "");
        pattern = pattern.replaceAll("https://", "");
        pattern = pattern.replaceAll("/*html", "");
        //使用/分割
        String[] part_url = url.split("/");
        String[] part_pattern = pattern.split("/");
        int i = 0;
        for (i = 0; i < Math.max(part_pattern.length, part_url.length); i++) {
            //如果当前模式串为*,说明前面已路径相等
            if (part_pattern[i].equals("*"))
                return true;
            //不相等，且模式串不为*
            if (!part_pattern[i].equals(part_url[i]))
                return false;
        }

        //只可能存在url太短，模式串太长的的情况，只需检查剩下的模式串是否为*即可
        return part_pattern[i].equals("*");
    }

    public static boolean matchUrl2(String url, String pattern) {
        //检验url是否合法
        Pattern p = Pattern.compile(urlVal);
        Matcher matcher = p.matcher(url);
        if (!matcher.matches())
            return false;
        //检查模式串是否含有*
        if (!pattern.contains("*"))
            return pattern.equals(url);
        Pattern p2 = Pattern.compile(pattern);
        Matcher matcher2 = p2.matcher(url);
        if (!matcher2.matches())
            return false;
        return true;
    }

    public static void main(String[] args) {
        String s1 = "https://m.taobao.com/test1/index.html";
        String s2 = "https://m.taobao.com/test1/test2/index.html";
        String s3 = "https://m.taobao.com/index.html";
        String p = "https://m.taobao.com/*/index.html";
        System.out.println(matchUrl2(s1, p));
        System.out.println(matchUrl2(s2, p));
        System.out.println(matchUrl2(s3, p));

        String s4 = "https://m.taobao.com/test1/test2/index.html";
        String p2 = "https://m.taobao.com/test2/*/index.html";
        System.out.println(matchUrl2(s4, p2));

        //测试不包含*的模式串
        String p3 = "https://m.taobao.com/test2";
        System.out.println(matchUrl2(s4, p3));

    }
}
