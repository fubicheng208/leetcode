package pdd;

import com.google.common.hash.BloomFilter;
import javafx.scene.effect.Bloom;

import java.util.HashSet;
import java.util.Scanner;

public class P4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] a = new int[m];
        for (int i = 0; i < m; i++) {
            a[i] = scanner.nextInt();
        }
        HashSet<Integer> hs = new HashSet<>();

        for (int num : a) {
            for (int i = 1; i <= n; i++) {
                if (i % num == 0) {
                    if (!hs.contains(i)) {
                        hs.add(i);
                    }
                }
            }
        }
        System.out.println(hs.size());
    }
}
