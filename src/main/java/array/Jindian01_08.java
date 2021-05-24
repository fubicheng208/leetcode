package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author fubic
 * @date 2021-02-02
 */
public class Jindian01_08 {
/*    编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
    示例 1：
    输入：
            [
            [1,1,1],
            [1,0,1],
            [1,1,1]
            ]
    输出：
            [
            [1,0,1],
            [0,0,0],
            [1,0,1]
            ]*/

    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return;
        }
        List<Integer> row = new ArrayList<>();
        List<Integer> col = new ArrayList<>();
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    row.add(i);
                    col.add(j);
                }
            }
        }
        Collections.sort(row);
        Collections.sort(col);
        for(int t : row){
            for(int j = 0; j < matrix[0].length; j++){
                matrix[t][j] = 0;
            }
        }

        for(int t : col){
            for(int i = 0; i < matrix.length; i++){
                matrix[i][t] = 0;
            }
        }
    }
}
