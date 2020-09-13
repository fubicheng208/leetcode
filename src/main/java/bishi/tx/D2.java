package bishi.tx;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class D2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        List<HashSet<Integer>> ls = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            for (int j = 0; j < x; j++) {
                HashSet<Integer> hs = new HashSet<>();
                hs.add(scanner.nextInt());
            }
        }

    }
}
