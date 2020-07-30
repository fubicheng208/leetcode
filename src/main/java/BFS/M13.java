package BFS;

public class M13 {
    int res = 0;
    int dx[] = {-1, 0, 1, 0};
    int dy[] = {0, -1, 0, 1};
    int m;
    int n;
    int k;

    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        int visited[][] = new int[m][n];
        dfs(visited, 0, 0);
        return res;
    }

    public void dfs(int visited[][], int i, int j) {
        visited[i][j] = 1;
        res++;
        for (int t = 0; t < 4; t++) {
            int x = i + dx[t];
            int y = j + dy[t];
            if (!(x >= 0 && x < m && y >= 0 && y < n)) continue;
            if (visited[x][y] == 0) {
                if (bitSum(x) + bitSum(y) <= k)
                    dfs(visited, x, y);
                else {
                    visited[x][y] = 1;
                    continue;
                }
            }
        }

    }

    public int bitSum(int x) {
        int res = 0;
        while (x != 0) {
            int pop = x % 10;
            x = x / 10;
            res += pop;
        }
        return res;
    }

    public static void main(String[] args) {
        M13 m = new M13();
        System.out.println(m.movingCount(7, 2, 3));
    }
}
