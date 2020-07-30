package sort;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution912 {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void quickSort(int[] nums, int l, int r) {
        int tmp = 0;
        int i = l;
        int j = r;
        if (l < r) {
            //保存枢纽
            tmp = nums[l];
            while (i < j) {
                //先移右边
                while (i < j && nums[j] >= tmp) {
                    j--;
                }
                //保证退出循环是由于第二个条件
                if (i < j) {
                    nums[i] = nums[j];
                    i++;
                }
                //再移左边
                while (i < j && nums[i] <= tmp) {
                    i++;
                }
                if (i < j) {
                    nums[j] = nums[i];
                    j--;
                }
            }
            //将枢纽移动到最后的位置
            nums[i] = tmp;
            //递归对左右分别排序
            quickSort(nums, l, i - 1);
            quickSort(nums, i + 1, r);
        }
    }

//    public static void Shellsort(int Array[], int n) {
//
//        int d = n / 2;//设置起始增量
//        while (d >= 1)//增量为1时排序结束
//        {
//            for (int k = 0; k < d; ++k)//遍历所有的子序
//            {
//                for (int i = k + d; i < n; i += d)//对每个子序进行插入排序
//                {
//                    int temp = Array[i];
//                    int j = i - d;
//                    while (j >= k && Array[j] > temp) {
//                        Array[j + d] = Array[j];
//                        j -= d;
//                    }
//                    Array[j + d] = temp;
//                }
//            }
//            d = d / 2;//缩小增量
//        }
//    }

}
