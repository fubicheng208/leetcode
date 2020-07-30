package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class Solution279 {

    private class Node {
        int val;
        int step;

        Node(int v, int s) {
            this.val = v;
            this.step = s;
        }
    }

    public int numSquares(int n) {
        Queue<Node> queue = new LinkedList<Node>();
        int[] flags = new int[n];
        queue.add(new Node(n, 1));
        while (!queue.isEmpty()) {
            Node top = queue.poll();
            int val = top.val;
            int step = top.step;
            for (int i = 1; ; i++) {
                int next_val = val - i * i;
                if (next_val == 0)
                    return step;
                if (next_val < 0)
                    break;

                if (flags[next_val] == 0) {
                    queue.add(new Node(next_val, step + 1));
                    flags[next_val] = 1;
                }
            }
        }
        return -1;
    }
}
