package sort;

public class Solution {
    /**
     * @param nums:   an integer array and all positive numbers
     * @param target: An integer
     * @return: An integer
     */
    public int backPackV(int[] nums, int target) {
        // write your code here
//        int dp[][] = new int[nums.length + 1][target + 1];
//        dp[0][0] = 1;
//        for(int i=1; i<dp.length; i++){
//            for(int j=0; j<dp[0].length; j++){
//                if(nums[i-1] > j)
//                    dp[i][j] = dp[i-1][j];
//                else
//                    dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i-1]];
//            }
//        }
//        return dp[nums.length][target];

        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] + dp[j - num];
            }
        }
        return dp[target];
    }
}