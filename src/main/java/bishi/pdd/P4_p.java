package bishi.pdd;

import java.util.Scanner;

public class P4_p {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        boolean[] fs = new boolean[1000000000];
        int[] a = new int[m];
        for (int i = 0; i < m; i++) {
            a[i] = scanner.nextInt();
        }
        int bit = 0;
        for (int num : a) {
            for (int i = 1; i <= n / num; i++) {
                bit |= (1 << i * num);
            }
        }
        int cnt = 0;
        while (bit != 0) {
            bit &= bit - 1;
            cnt++;
        }
        System.out.println(cnt);
    }
}
