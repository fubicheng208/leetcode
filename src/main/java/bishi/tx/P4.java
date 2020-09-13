package bishi.tx;

import java.util.*;

public class P4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> ls = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ls.add(scanner.nextInt());
        }
        for (int i = 0; i < n; i++) {
            int tmp = ls.get(i);
            ls.remove(i);
            ls.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
            System.out.println(ls.get((ls.size()-1)/2));
            ls.add(tmp);
        }
    }
}
