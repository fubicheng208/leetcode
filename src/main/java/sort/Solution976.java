package sort;

/*给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。

        如果不能形成任何面积不为零的三角形，返回 0。*/


import java.util.Arrays;

public class Solution976 {
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for (int i = A.length - 1; i >= 2; i--) {
            if (A[i - 2] + A[i - 1] > A[i])
                return A[i - 2] + A[i - 1] + A[i];
        }
        return 0;
    }
}
