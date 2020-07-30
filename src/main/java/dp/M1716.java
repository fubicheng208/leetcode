package dp;

public class M1716 {
    public static int message(int[] nums) {
        int len = nums.length;
        if (len == 1)
            return nums[0];
        else if (len == 2)
            return Math.max(nums[0], nums[1]);
        else if (len == 3) {
            return Math.max(nums[0] + nums[2], nums[1]);
        } else {
            int[] dp = new int[len];
            dp[0] = nums[0];
            dp[1] = nums[1];
            dp[2] = Math.max(nums[0] + nums[2], nums[1]);
            for (int i = 3; i < len; i++) {
                dp[i] = Math.max(dp[i - 2], dp[i - 3]) + nums[i];
            }
            return dp[len - 1];
        }
    }
}
