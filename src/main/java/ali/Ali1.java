package ali;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Ali1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();//n个养鸡场
        int m = in.nextInt();//m天后
        int k = in.nextInt();//每天增加小鸡
        long a[] = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextLong();
//            q.add(a[i]);
        }
        for (int i = 0; i < m; i++) {
            int max_j = -1;
            long MAX = Long.MIN_VALUE;
            for (int j = 0; j < n; j++) {
                a[j] += k;
                if (a[j] > MAX) {
                    max_j = j;
                    MAX = a[j];
                }
            }
            //减半操作
            a[max_j] = a[max_j] / 2;
        }
        long res = 0;
        for (long t : a) {
            res += t;
        }
        System.out.print(res);
    }
}
