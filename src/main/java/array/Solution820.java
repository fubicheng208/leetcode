package array;

import java.util.HashMap;
import java.util.Map;

public class Solution820 {
    public static int minimumLengthEncoding(String[] words) {
        int[] flags = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            if (flags[i] == 0) {
                for (int j = i + 1; j < words.length; j++) {
                    int index1 = words[j].indexOf(words[i]);
                    //是否是子串，且是否是后缀子串（即abcd和bcd是，但abcd和bc不是）
                    if (index1 != -1 && index1 + words[i].length() == words[j].length()) {
                        flags[i] = 1;
                        break;
                    }
                    int index2 = words[i].indexOf(words[j]);
                    if (index2 != -1 && index2 + words[j].length() == words[i].length()) {
                        flags[j] = 1;
                    }
                }
            }
        }
        int res = 0;
        for (int i = 0; i < words.length; i++) {
            if (flags[i] == 0)
                res += words[i].length() + 1;
        }
        return res;
    }

//    public int minimumLengthEncoding(String[] words) {
//        Map<String, Integer> hm = new HashMap<>();
//        for (String s : words) {
//            hm.put(s, 0);
//        }
//        for (int i = 0; i < words.length; i++) {
//            if (hm.get(words[i]) == 0) {
//                for (int j = i + 1; j < words.length; j++) {
//                    if (words[j].contains(words[i])) {
//                        hm.put(words[i], 1);
//                        break;
//                    }
//                    if (words[i].contains(words[j])) {
//                        hm.put(words[j], 1);
//                    }
//                }
//            }
//        }
//        int res = 0;
//        for (Map.Entry<String, Integer> entry : hm.entrySet()) {
//            if(entry.getValue()==0)
//                res += entry.getKey().length() + 1;
//        }
//        return res;
//    }
}
