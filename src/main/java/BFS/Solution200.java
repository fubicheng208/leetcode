package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class Solution200 {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    Queue<int[]> queue = new LinkedList<int[]>();
                    queue.add(new int[]{i, j});
                    cnt++;
                    while (!queue.isEmpty()) {
                        int[] tmp = queue.poll();
                        int t_i = tmp[0];
                        int t_j = tmp[1];
                        if (t_i - 1 >= 0 && grid[t_i - 1][t_j] == '1') {
                            grid[t_i - 1][t_j] = '0';
                            queue.add(new int[]{t_i - 1, t_j});
                        }
                        if (t_i + 1 < m && grid[t_i + 1][t_j] == '1') {
                            grid[t_i + 1][t_j] = '0';
                            queue.add(new int[]{t_i + 1, t_j});
                        }
                        if (t_j - 1 >= 0 && grid[t_i][t_j - 1] == '1') {
                            grid[t_i][t_j - 1] = '0';
                            queue.add(new int[]{t_i, t_j - 1});
                        }
                        if (t_j + 1 < n && grid[t_i][t_j + 1] == '1') {
                            grid[t_i][t_j + 1] = '0';
                            queue.add(new int[]{t_i, t_j + 1});
                        }
                    }
                }
            }
        }
        return cnt;
    }

}
