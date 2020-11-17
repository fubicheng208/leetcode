package sort;

public class SelectSort {
    //每一轮在无序数组中选出一个最小数，和无序数组第一个做交换
    public static void selectSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int k = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[k]) {
                    k = j;
                }
            }
            int tmp = nums[i];
            nums[i] = nums[k];
            nums[k] = tmp;
        }
    }
}
