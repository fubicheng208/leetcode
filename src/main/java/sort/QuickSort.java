package sort;

public class QuickSort {
    public static void quickSort(int[] nums, int l, int r) {
        /*if(l>=r)
            return;*/
        int i = l;
        int j = r;
        int pivot = nums[(l + r) / 2];
        while (i <= j) {
            //直到找到比支点大的数,不能是>=，考虑俩个数的情况 7，2，也要做交换
            while (pivot > nums[i])
                i++;
            while (pivot < nums[j])
                j--;
            //两数做交换
            if (i <= j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
                j--;
            }
        }
        //递归对左边排序
        if (l < j)
            quickSort(nums, l, j);
        if (i < r)
            quickSort(nums, i, r);
    }
}
