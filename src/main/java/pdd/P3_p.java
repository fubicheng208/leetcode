package pdd;

import java.util.Scanner;

public class P3_p {
    /*
    *
    * 4 4
-1 -1
1 -1
-1 1
6 6 */


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
        int[][] dp = new int[200][5010];
        dp[0][5000] = 1;

        for (int i = 1; i <=m ; i++) {
            for (int j = 0; j <= 10000 ; j++) {
                for (int k = 1; k <= n ; k++) {
                    dp[i][j + c[k] * v[i]] += dp[i-1][j];
                }
            }
        }
        System.out.println(dp[m][5000]);
    }
}
