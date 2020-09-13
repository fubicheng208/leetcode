package sort;

public class BubbleSort {
    public static int[] bubbleSort(int[] nums) {
        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = tmp;
                }
            }
        }
        return nums;
    }
}
