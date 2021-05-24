package array;

/**
 * @author fubic
 * @date 2021-01-30
 */
public class Jindian01_03 {
/*    URL化。编写一种方法，将字符串中的空格全部替换为%20。假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。（注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）
    示例 1：
    输入："Mr John Smith    ", 13
    输出："Mr%20John%20Smith"

    示例 2：
    输入："               ", 5
    输出："%20%20%20%20%20"*/

    //API法
/*    public String replaceSpaces(String S, int length) {
        return S.substring(0, length).replace(" ", "%20");
    }*/

    //按题意写
    public String replaceSpaces(String S, int length) {
        char[] cs = new char[length * 3];
        int t = 0;
        //只取真实长度，以免"Mr John Smith    "时Smith后面的空格也被输出出来
        for (int i = 0; i < length; i++) {
            char c = S.charAt(i);
            if (c == ' ') {
                cs[t++] = '%';
                cs[t++] = '2';
                cs[t++] = '0';
            } else {
                cs[t++] = c;
            }
        }
        return new String(cs, 0, t);
    }
}
