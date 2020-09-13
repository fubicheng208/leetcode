package bishi.yfd;

import java.util.Scanner;

public class P1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int[] res = new int[n];
        System.arraycopy(a, 0, res, 0, a.length);
        for (int i = 0; i < m; i++) {
            int[] tmp = new int[n];
            int half = n / 2;
            int index = 0;
            for (int j = 0; j < half; j+=1) {
                tmp[index++] = res[j + half];
                tmp[index++] = res[j];
            }
            if(n % 2 == 1){
                tmp[tmp.length - 1] = res[res.length - 1];
            }
            res = tmp;
        }
        System.out.print(res[0]);
        for (int i = 1; i < res.length; i++) {
            System.out.printf(" %d", res[i]);
        }
    }
}
