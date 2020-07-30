package array;

import java.util.Arrays;

public class M0107 {
    /*    public void rotate(int[][] matrix) {
            int m = matrix.length;
            //先做水平翻转再做主对角线反转方法
            for(int i=0; i<m/2; i++){
                for(int j=0; j<m; j++){
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[m-1-i][j];
                    matrix[m-1-i][j] = tmp;
                }
            }
            for(int i=0; i<m; i++){
                for(int j=0; j<i; j++){
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = tmp;
                }
            }
        }*/
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        int tmp[][] = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                tmp[j][m - 1 - i] = matrix[i][j];
            }
        }
        for (int i = 0; i < m; i++) {
            matrix[i] = Arrays.copyOf(tmp[i], tmp[i].length);
        }
    }

}
