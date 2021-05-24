package bishi.tx;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> ls1 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ls1.add(scanner.nextInt());
        }
        List<Integer> res = new ArrayList<>();
        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            int t = scanner.nextInt();
            if (ls1.contains(t)) {
                res.add(t);
            }
        }
        if (res.size() == 0)
            System.out.println();
        else {

            System.out.print(res.get(0));
            for (int i = 1; i < res.size(); i++) {
                System.out.printf(" %d", res.get(i));
            }
        }
    }
}
