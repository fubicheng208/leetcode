package array;

import java.util.Arrays;

public class Solution289 {
    int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public void gameOfLife(int[][] board) {
//        int[][] tmp = Arrays.copyOf(board);
//
        int m = board.length;
        int n = board[0].length;
        int[][] tmp = new int[m][n];
        for (int i = 0; i < m; i++) {
            tmp[i] = Arrays.copyOf(board[i], board[i].length);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (tmp[i][j] == 1) {
                    int cnt = 0;
                    for (int k = 0; k < 8; k++) {
                        int x = i + dx[k];
                        int y = j + dy[k];
                        //边界下一个
                        if (!(x >= 0 && x < m && y >= 0 && y < n)) continue;
                        if (tmp[x][y] == 1)
                            cnt++;
                    }
                    if (cnt < 2 || cnt > 3)
                        board[i][j] = 0;
                } else {
                    int cnt = 0;
                    for (int k = 0; k < 8; k++) {
                        int x = i + dx[k];
                        int y = j + dy[k];
                        //边界下一个
                        if (!(x >= 0 && x < m && y >= 0 && y < n)) continue;
                        if (tmp[x][y] == 1)
                            cnt++;
                    }
                    if (cnt == 3)
                        board[i][j] = 1;
                }
            }
        }
    }
}
