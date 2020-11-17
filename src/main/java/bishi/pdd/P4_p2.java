package bishi.pdd;

import java.util.HashSet;
import java.util.Scanner;

public class P4_p2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] a = new int[m];
        for (int i = 0; i < m; i++) {
            a[i] = scanner.nextInt();
        }
        HashSet<Integer> hs = new HashSet<>();
        boolean[] fs= new boolean[1000000001];

        for (int num : a) {
            for (int i = 1; i <= n / num ; i++) {
//                if (!hs.contains(i * num)) {
//                    hs.add(i * num);
//                }
                fs[i * num] = true;
            }
        }

        int cnt = 0;
        for(Boolean b : fs){
            if (b)
                cnt++;
        }

        System.out.println(cnt);
    }
}
