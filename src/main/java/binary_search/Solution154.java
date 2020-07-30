package binary_search;

public class Solution154 {
    public static int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (nums[mid] > nums[r]) l = mid + 1;//此时mid只可能是最小值下标的前一个点
            else if (nums[mid] < nums[r]) r = mid;//不可mid-1,因为若mid正好选中最小值下标，减1会错过这个点
            else r--;
        }
        return nums[l];
    }
}
