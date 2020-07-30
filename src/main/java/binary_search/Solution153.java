package binary_search;


/*假设按照升序排序的数组在预先未知的某个点上进行了旋转。
        ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
        请找出其中最小的元素。
        你可以假设数组中不存在重复元素。
        示例 1:
        输入: [3,4,5,1,2]
        输出: 1*/


public class Solution153 {
    public static int findMin(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];
        int l = 0;
        int r = n - 1;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (nums[mid] < nums[mid - 1 < 0 ? n - 1 : mid - 1] && nums[mid] < nums[mid + 1 == n ? 0 : mid + 1])
                return nums[mid];
            else if (nums[mid] > nums[l])
                l = mid;
            else
                r = mid;
        }
        return -1;
    }
}
