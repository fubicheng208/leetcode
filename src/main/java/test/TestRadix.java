package test;

import com.sun.xml.internal.bind.v2.model.runtime.RuntimeArrayInfo;

public class TestRadix {
    public static void main(String[] args) {
        int i = 16;
        System.out.println(toTenInt("0", 2));
    }

    public static int toTenInt(String s, int radix) {
        if (s == null || s.length() == 0 || radix < 2) {
            throw new RuntimeException("");
        }
        boolean negative = false;
        int i = 0;
        if (s.charAt(0) == '-') {
            negative = true;
            i++;
        }
        int res = 0;
        for (; i < s.length(); i++) {
            int num = (s.charAt(i) - '0');
            res = res * radix + num;
        }
        return negative ? -res : res;
    }

}
