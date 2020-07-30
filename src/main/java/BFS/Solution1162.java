package BFS;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.w3c.dom.ls.LSOutput;

import javax.xml.soap.Node;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Solution1162 {

    static final int dx[] = {-1, 0, 1, 0}, dy[] = {0, -1, 0, 1};
    int m, n;
    int[][] a;

    public int maxDistance(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        a = grid;
        int ans = -1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    ans = Math.max(ans, BFS(i, j));
                }
            }
        }
        return ans;
    }

    public int BFS(int i, int j) {
        int ans = -1;
        int visited[][] = new int[m][n];
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(i, j, 0));
        visited[i][j] = 1;
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int t = 0; t < 4; t++) {
                int nx = p.x + dx[t];
                int ny = p.y + dy[t];
                //越界则下一点
                if (!(nx >= 0 && nx < m && ny >= 0 && ny < n)) continue;
                //访问过则下一点
                if (visited[nx][ny] == 0) {
                    if (a[nx][ny] == 1)
                        return p.step + 1;
                    queue.add(new Point(nx, ny, p.step + 1));
                    visited[nx][ny] = 1;
                }
            }
        }
        return ans;
    }

    class Point {
        int x, y, step;

        public Point(int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
        }
    }
}

class Main {
    public static void main(String[] args) {
        Solution1162 s = new Solution1162();
        int grid[][] = {{1, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        System.out.println(s.maxDistance(grid));
    }
}
