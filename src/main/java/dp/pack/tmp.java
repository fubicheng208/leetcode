package dp.pack;

public class tmp {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        //        // write your code here
//        int dp[][] = new int[A.length + 1][m+1];
//        for(int i=1; i<dp.length; i++){
//            for(int j=1; j<dp[0].length; j++){
//                //如果当前物体的体积大于背包容量,则不放这个物体
//                if(A[i-1] > j)
//                    dp[i][j] = dp[i-1][j];
//                //如果当前物体的体积小于等于背包容量，则可以选择放或者不放
//                //若放，则等于前n-1物体放入到容量为j-A[i-1]的背包中的最大容量，加上此物体的体积
//                else
//                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-A[i-1]] + A[i-1]);
//            }
//        }
////        前m个物体容积为j的背包可以放下，则j+1...的背包一定也可以放下；即dp[i][j-1]<=dp[i][j]
//        return dp[A.length][m];

        int dp[] = new int[m+1];
        for(int num : A){
            for(int j = m; j >= num; j--){
                dp[j] = Math.max(dp[j], dp[j - num] + num);
            }
        }
        return dp[m];
    }

    public int backPackII(int m, int[] A, int[] V) {
        //        // write your code here
//        int dp[][] = new int[A.length + 1][m + 1];
//        for(int i=1; i<dp.length; i++){
//            //j表示可放空间为j
//            for(int j=1; j<dp[0].length; j++){
//                if(A[i-1] > j)
//                    dp[i][j] = dp[i-1][j];
//                else
//                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-A[i-1]] + V[i-1]);
//            }
//        }
//        return dp[A.length][m];

        int dp[] = new int[m+1];
        for(int i = 0; i < A.length; i++){
            for(int j = m; j >= A[i]; j--){
                dp[j] = Math.max(dp[j], dp[j - A[i]] + V[i]);
            }
        }
        return dp[m];
    }

    public int backPackIV(int[] nums, int target) {
        // write your code here
//        int dp[][] = new int[nums.length + 1][target + 1];
//        dp[0][0] = 1;
//        for(int i=1; i<dp.length; i++){
//            for(int j=0; j<dp[0].length; j++){
//                if(nums[i-1] > j)
//                    dp[i][j] = dp[i-1][j];
//                else
//                    dp[i][j] = dp[i-1][j] + dp[i][j-nums[i-1]];
//            }
//        }
//        return dp[nums.length][target];

        int dp[] = new int[target + 1];
        dp[0] = 1;
        for(int num : nums){
            for(int j = num; j <= target; j++)
                dp[j] = dp[j] + dp[j - num];
        }
        return dp[target];
    }

    public class Solution {
        /**
         * @param nums: an integer array and all positive numbers
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
            for(int num : nums){
                for(int j = target; j >= num; j--){
                    dp[j] = dp[j] + dp[j - num];
                }
            }
            return dp[target];
        }
    }
}
