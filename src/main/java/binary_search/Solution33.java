package binary_search;

public class Solution33 {
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (nums[mid] > nums[r]) l = mid + 1;//此时mid只可能是最小值下标的前一个点
            else if (nums[mid] < nums[r]) r = mid;//不可mid-1,因为若mid正好选中最小值下标，减1会错过这个点
            else r--;
        }
        //l为pivot
        if (target > nums[0])
            return searchInSub(nums, 0, l - 1 < 0 ? n - 1 : l - 1, target);
        else if (target < nums[0])
            return searchInSub(nums, l, n - 1, target);
        else
            return 0;

    }

    public static int searchInSub(int[] nums, int l, int r, int target) {
//        int l = 0;
//        int r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (nums[mid] > target)
                r = mid - 1;
            else if (nums[mid] < target)
                l = mid + 1;
            else
                return mid;
        }
        return -1;
    }
}
