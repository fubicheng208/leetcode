package binary_search;

public class M53_2 {
/*    一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
    示例 1:
    输入: [0,1,3]
    输出: 2*/

    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int l = 0;
        int r = nums.length - 1;
        while(l <= r){
            int mid = (l + r) >> 1;
            if(nums[mid] == mid){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return l;
    }
}