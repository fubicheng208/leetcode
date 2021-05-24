package string;

/**
 * @author fubic
 * @date 2021-01-07
 */
public class Solution434 {
    public int countSegments(String s) {
        s = s.trim();
        if(s == null || s.length() == 0){
            return 0;
        }
//        String[] ss = s.split(" ");
        return s.split("\\s+").length;
    }
}
