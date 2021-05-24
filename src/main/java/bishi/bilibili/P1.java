package bishi.bilibili;

import java.util.TreeMap;

public class P1 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param arr int整型一维数组
     * @param k   int整型 允许0变为1的个数
     * @return int整型
     */
    public static int GetMaxConsecutiveOnes(int[] arr, int k) {
        int l = 0, r = 0, max = 0;
        while (l <= r && r < arr.length) {
            while (r < arr.length && (arr[r] != 0 || k != 0)) {
                if (arr[r] == 0) {
                    k--;
                }
                r++;
            }
            max = Math.max(r - l, max);
            if (arr[l] != 0) {
                l++;
            } else {
                l++;
                r++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;
        System.out.println(GetMaxConsecutiveOnes(arr, k));
    }
}
