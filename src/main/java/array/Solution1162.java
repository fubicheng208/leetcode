package array;

public class Solution1162 {
    //0代表海洋，1代表陆地=》与所有1最远的0，=》该0和离他最近的1的距离
    public static int maxDistance(int[][] grid) {
        int maxDistance = Integer.MIN_VALUE;
        int maxI = -1;
        int maxJ = -1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    int minDistance = Integer.MAX_VALUE;
                    for (int m = 0; m < grid.length; m++) {
                        for (int n = 0; n < grid[0].length; n++) {
                            if (grid[m][n] == 1 && !(m == i && n == j)) {
                                int dis = Math.abs(i - m) + Math.abs(j - n);
                                if (dis < minDistance)
                                    minDistance = dis;
                            }
                        }
                    }
                    if (minDistance > maxDistance) {
                        maxDistance = minDistance;
                        maxI = i;
                        maxJ = j;
                    }
                }
            }
        }
        //不存在陆地
        if (maxDistance == Integer.MAX_VALUE || maxDistance == Integer.MIN_VALUE) {
            return -1;
        }
        int minDistanceWithIJ = Integer.MAX_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int dis = Math.abs(i - maxI) + Math.abs(j - maxJ);
                    if (dis < minDistanceWithIJ)
                        minDistanceWithIJ = dis;
                }
            }
        }
        return minDistanceWithIJ;
    }
}
