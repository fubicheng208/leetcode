package dp.pack;

import java.util.Arrays;

public class Lint564_combination_full {
    public int backPackVI(int[] nums, int target) {
        // write your code here

        int dp[] = new int[target + 1];
        dp[0] = 1;
        Arrays.sort(nums);
        for(int j = 1; j <= target; j++){
            for(int num : nums){
                if(num > j)
                    break;
                dp[j] = dp[j] + dp[j - num];
            }
        }
        return dp[target];

/*        int[] dp = new int[target + 1];
        dp[0] = 1;
        for(int num : nums){
            for (int j = num; j <= target ; j++) {
                //不放这个物体的方法数+放这个物体的方法数
                dp[j] = dp[j] + dp[j - num];
            }
        }
        return dp[target];  */
    }
}
