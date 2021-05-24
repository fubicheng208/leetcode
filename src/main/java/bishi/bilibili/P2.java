package bishi.bilibili;

import sun.font.FontRunIterator;

public class P2 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param matrix int整型二维数组
     * @return int整型一维数组
     */
    public int[] SpiralMatrix(int[][] matrix) {
        // write code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int lenR = matrix.length;
        int lenC = matrix[0].length;
        int total = lenC * lenR;
        int[] root = new int[total];
        int r = 0;
        int c = 0;
        int index = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[][] v = new int[lenR][lenC];
        for (int i = 0; i < total; i++) {
            root[i] = matrix[r][c];
            v[r][c] = 1;
            int nextR = r + directions[index][0];
            int nextC = c + directions[index][1];
            if (nextR >= lenR || nextR < 0 || nextC >= lenC || nextC < 0 || v[nextR][nextC] == 1) {
                index = (index + 1) % 4;
            }
            r += directions[index][0];
            c += directions[index][1];
        }
        return root;
    }
}
