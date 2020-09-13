package pdd;

import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); //商品总数
        int m = scanner.nextInt(); //背包大小
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = scanner.nextInt();
            }
        }
        System.out.println(10);
    }
}
