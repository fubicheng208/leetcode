package bishi.tx;

import java.util.*;

public class P4_p {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> ls = new ArrayList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int tmp = scanner.nextInt();
            ls.add(tmp);
            hm.put(i, tmp);
        }
        ls.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for (int i = 0; i < n; i++) {
            int v = hm.get(i);
            int index = ls.indexOf(v);
            if (index < n / 2) {
                System.out.println(ls.get(n / 2));
            } else {
                System.out.println(ls.get(n / 2 - 1));
            }
        }
    }
}
