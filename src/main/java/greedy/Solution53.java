package greedy;

public class Solution53 {
    //    给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
//    示例:
//
//    输入: [-2,1,-3,4,-1,2,1,-5,4],
//    输出: 6
//    解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
    public int maxSubArray(int[] nums) {
        int cur_sum = nums[0];
        int max_sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            cur_sum = Math.max(nums[i], nums[i] + cur_sum);//选择是从新从当前数字开始/继续上一个连续序列（取大的，贪心）
            max_sum = Math.max(max_sum, cur_sum);
        }
        return max_sum;
    }
}
