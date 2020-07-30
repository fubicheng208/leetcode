package DFS;

public class Solution130 {
    public void solve(char[][] board) {
        if (board == null || board.length == 0)
            return;
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && (i == 0 || i == m - 1 || j == 0 || j == n - 1))
                    bfs(board, i, j, m, n);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = board[i][j] == '#' ? 'O' : 'X';
            }
        }
    }

    public void bfs(char[][] board, int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n)
            return;
        if (board[i][j] == 'X' || board[i][j] == '#')
            return;
        board[i][j] = '#';
        //中间的O,继续向四个方向DFS
        bfs(board, i - 1, j, m, n);
        bfs(board, i + 1, j, m, n);
        bfs(board, i, j - 1, m, n);
        bfs(board, i, j + 1, m, n);
    }
}
