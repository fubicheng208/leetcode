package bishi.meituan;

import java.util.Scanner;

public class P3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            int tmp = 0;
            for (int j = 1; j <= n; j++) {
                tmp ^= (i + 1) % j;
            }
            b[i] = a[i] ^ tmp;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res ^= b[i];
        }
        System.out.println(res);
    }
}
