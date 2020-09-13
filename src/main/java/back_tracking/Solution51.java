package back_tracking;

import java.lang.reflect.Array;
import java.util.*;

public class Solution51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        Set<Integer> columns = new HashSet<>();
        Set<Integer> diagonals1 = new HashSet<>();
        Set<Integer> diagonals2 = new HashSet<>();
        backtrack(solutions, queens, n, 0, columns, diagonals1, diagonals2);
        return solutions;

    }

    public void backtrack(List<List<String>> solutions, int[] queens, int n, int row,  Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2){
        if(row == n){
            solutions.add(generateBoard(queens));
            return;
        }
        //递归改行所有列
        for (int i = 0; i < n; i++) {
            if (columns.contains(i)){
                continue;
            }
            //横对角线上差相同
            int diagonal1 = row - i;
            if(diagonals1.contains(diagonal1)){
                continue;
            }
            //斜对角线上和相同；
            int diagonal2 = row + i;
            if(diagonals2.contains(diagonal2)){
                continue;
            }
            //则可以放置子在此列
            queens[row] = i;
            columns.add(i);
            diagonals1.add(diagonal1);
            diagonals2.add(diagonal2);
            backtrack(solutions, queens, n, row + 1, columns, diagonals1, diagonals2);
            //递归回来，撤子
            queens[row] = -1;
            columns.remove(i);
            diagonals1.remove(diagonal1);
            diagonals2.remove(diagonal2);

        }


    }

    public List<String> generateBoard(int[] queens){
        List<String> board = new ArrayList<>();
        for (int i = 0; i < queens.length; i++) {
            char[] arr = new char[queens.length];
            Arrays.fill(arr, '.');
            arr[queens[i]] = 'Q';
            board.add(new String(arr));
        }
        return board;
    }
}
