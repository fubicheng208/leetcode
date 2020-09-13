package dp.pack;

public class Lint563_01_cnt {
    /*    给出 n 个物品, 以及一个数组, nums[i] 代表第i个物品的大小, 保证大小均为正数, 正整数 target 表示背包的大小, 找到能填满背包的方案数。
        每一个物品只能使用一次

        给出候选物品集合 [1,2,3,3,7] 以及 target 7
        结果的集合为:
                [7]
                [1,3,3]
        返回 2*/
    public int backPackV(int[] nums, int target) {
        int[][] dp = new int[nums.length + 1][target + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <= target; j++) {
                if (nums[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    //不放的方法数+放的方法数
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[nums.length][target];
    }

    public int backPackVV2(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = target; j >= nums[i - 1]; j--) {
                dp[j] = dp[j] + dp[j - nums[i - 1]];
            }
        }
        return dp[target];
    }
}
