package bishi.pdd;

import java.util.Scanner;

public class P3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); //商品总数
        int m = scanner.nextInt(); //背包大小
        int[] c = new int[n];
        int[] v = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = scanner.nextInt();
            v[i] = scanner.nextInt();
        }
        int[] dp = new int[m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = m; j > c[i] - 1; j--) {
                dp[j] = Math.max(dp[j - c[i]] + v[i], dp[j]);
            }
        }
        System.out.println(dp[m]);
    }
}
