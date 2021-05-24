package bishi.meituan;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class P1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int p = scanner.nextInt();
        int q = scanner.nextInt();
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();

        for (int i = 0; i < p; i++) {
            s1.add(scanner.nextInt());
        }
        for (int i = 0; i < q; i++) {
            s2.add(scanner.nextInt());
        }

        Set<Integer> s1T = new HashSet<>();
        for (Integer a : s1) {
            s1T.add(a);
        }

        Set<Integer> s2T = new HashSet<>();
        for (Integer a : s2) {
            s2T.add(a);
        }

        s1T.removeAll(s2);
        int onlyP = s1T.size();
        s2T.removeAll(s1);
        int onlyQ = s2T.size();

        s1.retainAll(s2);
        int all = s1.size();

        System.out.printf("%d %d %d", onlyP, onlyQ, all);

    }
}
