package bishi.bytedance;

import java.math.BigInteger;
import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ss = sc.next();
        System.out.println(ss);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            BigInteger a = sc.nextBigInteger();
            BigInteger b = sc.nextBigInteger();
            String s = sc.nextLine();
            System.out.println(a);
            System.out.println(b);
            System.out.println(s);

        }
    }
}
