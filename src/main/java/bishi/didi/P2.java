package bishi.didi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class P2 {
    static class Node {
        public int a, b;
        public int dis;

        public Node(int a, int b, int dis) {
            this.a = a;
            this.b = b;
            this.dis = dis;
        }

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            int[] fa = new int[n + 1];
            List<Node> ls = new ArrayList<>();
            for (int j = 0; j <= n; j++) {
                fa[j] = j;
            }
            for (int j = 0; j < m; j++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                int d = sc.nextInt();
                if (d <= k) {
                    ls.add(new Node(a, b, d));
                }
            }
            ls.sort(new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    return o1.dis - o2.dis;
                }
            });
            int ans = 0;
            for (Node d : ls) {
                ans += mergeFa(d.a, d.b, fa);
            }
            if (ans >= n - 1) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    static int findFa(int x, int[] fa) {
        if (fa[x] == x) {
            return x;
        }
        return fa[x] = findFa(fa[x], fa);
    }

    static int mergeFa(int x, int y, int[] fa) {
        //找到根节点
        int fx = findFa(x, fa);
        int fy = findFa(y, fa);
        //这两个节点相互不通
        if (fx != fy) {
            fa[fx] = fy;
            //边数+1
            return 1;
        } else {
            return 0;
        }
    }
}
