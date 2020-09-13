package dp.pack;

public class Lint562_full_cnt {
/*    给出 n个物品,以及一个数组,nums[i]代表第i个物品的大小,保证大小均为正数并且没有重复,
    正整数 target
    表示背包的大小,找到能填满背包的方案数。
    每一个物品可以使用无数次
    输入: nums = [2,3,6,7] 和 target = 7
    输出: 2
    解释:
    方案有:
            [7]
            [2, 2, 3]*/

    public int backPackIV(int[] nums, int target) {
        //此方法计算的是最大体积的大小
        /*int[][] dp = new int[nums.length + 1][target+1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if(nums[i-1] > j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j - nums[i-1]] + nums[i-1]);
                }
            }
        }
        return dp[nums.length][target];*/

        //此方法计算放满target的方法数
        int dp[][] = new int[nums.length + 1][target + 1];
        //0个物品，0体积，算一种方案
        dp[0][0] = 1;
        //前1个物体开始
        for (int i = 1; i < dp.length; i++) {
            //前i个物体，目标体积0，即1中方案（都不放）
            for (int j = 0; j < dp[0].length; j++) {
                if(nums[i-1] > j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    //因为一个物品可以放多次，所以dp[i]
                    dp[i][j] = dp[i-1][j] + dp[i][j-nums[i-1]];
                }
            }
        }
        return dp[nums.length][target];

    }

    public int backPackIVV2(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for(int num : nums){
            for (int j = num; j <= target ; j++) {
                //不放这个物体的方法数+放这个物体的方法数
                dp[j] = dp[j] + dp[j - num];
            }
        }
        return dp[target];
    }
}