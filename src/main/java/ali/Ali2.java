package ali;

import java.util.Arrays;
import java.util.Scanner;

public class Ali2 {
    public static void main(String[] args) {
        Long l;
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();//n个养鸡场
        long a[] = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextLong();
        }
        Arrays.sort(a);
        int times = 0;
        long res = 0;
        for (int i = 0; i < a.length; i++) {
            res += a[i] * (i + 1);
            times += i + 1;
        }
        System.out.printf("%.6f", res * 1.0 / times);
    }
}
