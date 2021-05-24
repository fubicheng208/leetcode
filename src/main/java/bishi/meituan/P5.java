package bishi.meituan;

import java.util.*;

public class P5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int[] a = new int[m];
        LinkedHashSet<Integer> ls = new LinkedHashSet<>();
        LinkedHashMap<Integer, Integer> lm = new LinkedHashMap<Integer, Integer>(100001, (float) 0.75, true);
        for (int i = 0; i < m; i++) {
            int t = scanner.nextInt();
            if (lm.containsValue(t)) {
                lm.get(t);
            } else {
                lm.put(t, t);
            }
        }
        for (Map.Entry entry : lm.entrySet()) {
            System.out.println(entry.getKey());
        }

    }
}
