package dp;

public class M42 {
//    输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
//
//    要求时间复杂度为O(n)。
//
//    示例1:
//
//    输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
//    输出: 6
//    解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。

    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        int max = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] < 0)//之前的累加已经小于0，另起炉灶
                dp[i] = nums[i];
            else//继续前一序列
                dp[i] = dp[i - 1] + nums[i];
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
