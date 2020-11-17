package bishi.pdd;

import java.util.Scanner;

public class P1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[][] a = new int[n][n];
        if(n % 2 == 0){
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(i < n/2 && j < n/2 && j > i){
                        a[i][j] = 2;
                    }else if(i < n/2 && j < n/2 && j < i){
                        a[i][j] = 3;
                    }else if(i >= n/2 && j < n/2 && j < n - 1 - i){
                        a[i][j] = 4;
                    }else if(i >= n/2 && j < n/2 && j > n - 1 - i){
                        a[i][j] = 5;
                    }else if(i >= n/2 && j >= n/2 && j < i){
                        a[i][j] = 6;
                    }else if(i >= n/2 && j >= n/2 && j > i){
                        a[i][j] = 7;
                    }else if(i < n/2 && j >= n/2 && j > n - 1 - i){
                        a[i][j] = 8;
                    }else if(i < n/2 && j >= n/2 && j < n - 1 - i){
                        a[i][j] = 1;
                    }
                }
            }
        }
        else{
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(i < n/2 && j < n/2 && j > i){
                        a[i][j] = 2;
                    }else if(i < n/2 && j < n/2 && j < i){
                        a[i][j] = 3;
                    }else if(i > n/2 && j < n/2 && j < n - 1 - i){
                        a[i][j] = 4;
                    }else if(i > n/2 && j < n/2 && j > n - 1 - i){
                        a[i][j] = 5;
                    }else if(i > n/2 && j > n/2 && j < i){
                        a[i][j] = 6;
                    }else if(i > n/2 && j > n/2 && j > i){
                        a[i][j] = 7;
                    }else if(i < n/2 && j > n/2 && j > n - 1 - i){
                        a[i][j] = 8;
                    }else if(i < n/2 && j > n/2 && j < n - 1 - i){
                        a[i][j] = 1;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.printf("%d", a[i][0]);
            for (int j = 1; j < n; j++) {
                System.out.printf(" %d", a[i][j]);
            }
            System.out.println();
        }
    }
}
