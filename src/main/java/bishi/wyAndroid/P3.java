package bishi.wyAndroid;

import java.util.Arrays;
import java.util.Scanner;

public class P3 {
    public static void main(String[] args) {
        int[] conditions = new int[1 << 6];
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int res = 0, status = 0;
        Arrays.fill(conditions, -1);
        //字符串长度为0，也符合题意
        conditions[0] = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a') {
                status ^= (1 << 0);
            } else if (c == 'b') {
                status ^= (1 << 1);
            } else if (c == 'c') {
                status ^= (1 << 2);
            } else if (c == 'x') {
                status ^= (1 << 3);
            } else if (c == 'y') {
                status ^= (1 << 4);
            } else if (c == 'z') {
                status ^= (1 << 5);
            }
            //如果之前有各位相同奇偶性的子串
            if (conditions[status] >= 0) {
                res = Math.max(res, i + 1 - conditions[status]);
            } else {
                conditions[status] = i + 1;
            }
        }
        System.out.println(res);
    }
}
