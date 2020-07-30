package array;

public class Solution999 {
    public int numRookCaptures(char[][] board) {
        int i = 0;
        int j = 0;
        label:
        for (i = 0; i < board.length; i++) {
            for (j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'R')
                    break label;
            }
        }

        int north = 0;
        if (i > 0) {
            for (int k = i - 1; k >= 0; k--) {
                if (board[k][j] == 'B')
                    break;
                if (board[k][j] == 'p') {
                    north++;
                    break;
                }
            }
        }


        int south = 0;
        if (i < board.length) {
            for (int k = i + 1; k < board.length; k++) {
                if (board[k][j] == 'B')
                    break;
                if (board[k][j] == 'p') {
                    south++;
                    break;
                }
            }
        }

        int east = 0;
        if (j > 0) {
            for (int l = j - 1; l >= 0; l--) {
                if (board[i][l] == 'B')
                    break;
                if (board[i][l] == 'p') {
                    east++;
                    break;
                }
            }
        }


        int west = 0;
        if (j < board[0].length) {
            for (int l = j + 1; l < board[0].length; l++) {
                if (board[i][l] == 'B')
                    break;
                if (board[i][l] == 'p') {
                    west++;
                    break;
                }
            }
        }
        return south + north + west + east;
    }
}
