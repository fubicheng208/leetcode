package bishi.pdd;

import java.util.*;

public class P2021_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N, M, T;
        N = sc.nextInt();
        M = sc.nextInt();
        T = sc.nextInt();

        List<Node> ls1 = new ArrayList<>();
        List<Node> ls2 = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            ls1.add(new Node(x, y));
        }
        for (int i = 0; i < M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            ls2.add(new Node(x, y));
        }
        Collections.sort(ls1);
        Collections.sort(ls2);
        int ans = Integer.MAX_VALUE;
        if (T != 0) {
            for (Node item : ls1) {
                if (item.y >= T)
                    ans = Math.min(ans, item.x);
            }
            int pos = ls1.size() - 1;
            for (Node item : ls2) {
                if (item.y >= T) {
                    ans = Math.min(ans, item.x);
                } else {
                    while (pos >= 0 && item.y + ls1.get(pos).y >= T) {
                        ans = Math.min(item.x + ls1.get(pos).x, ans);
                        pos--;
                    }
                }
            }
        } else {
            ans = 0;
        }
        if (ans == Integer.MAX_VALUE)
            ans = -1;
        System.out.println(ans);
    }

}

class Node implements Comparable<Node> {
    public int x;
    public int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Node n) {
        if (this.y == n.y) {
            if (this.x == n.x)
                return 0;
            else if (this.x < n.x) {
                return -1;
            } else {
                return 1;
            }
        }
        return this.y > n.y ? 1 : -1;
    }
}