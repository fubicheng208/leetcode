package greedy;

enum Index {
    GOOD, BAD, UNKNOWN
}

public class Solution55 {
//    回溯
    /*public boolean canJump(int[] nums) {
        return canJumpFromPosition(0, nums);
    }

    public boolean canJumpFromPosition(int position, int[] nums){
        if(position == nums.length  - 1)
            return true;
        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for(int i = furthestJump; i > position; i-- ){
            if(canJumpFromPosition(i, nums))
                return true;
        }
        return false;
    }*/
//    动态规划自顶向下
    /*Index[] memo;

    public boolean canJumpFromPosition(int position, int[] nums){
        if(memo[position] != Index.UNKNOWN)
            return memo[position] == Index.GOOD ? true : false;//相当于做了减枝

        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for(int i = position + 1; i <= furthestJump; i++){
            if(canJumpFromPosition(i, nums)){
                memo[position] = Index.GOOD;//保存状态
                return true;
            }
        }

        memo[position] = Index.BAD;
        return false;
    }

    public boolean canJump(int[] nums){
        memo = new Index[nums.length];
        for(int i = 0; i < memo.length; i++)
            memo[i] = Index.UNKNOWN;
        memo[memo.length - 1] = Index.GOOD;
        return canJumpFromPosition(0, nums);
    }*/

    //    动态规划自底向上
    /*public boolean canJump(int[] nums){
        Index[] memo = new Index[nums.length];
        for(int i = 0; i<memo.length; i++){
            memo[i] = Index.UNKNOWN;
        }
        memo[memo.length - 1] = Index.GOOD;

        for(int i = nums.length - 2; i >= 0; i--){
            int furthestJump = Math.min(i + nums[i], nums.length - 1);
            for( int j = i+1; j  <= furthestJump; j++){
                if(memo[j] == Index.GOOD) {
                    memo[i] = Index.GOOD;
                    break;
                }
            }
        }
        return memo[0] == Index.GOOD;
    }*/
//  贪心,能到达尾巴的最左元素->能到达尾巴的最左元素->...
    public boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] + i >= lastPos)
                lastPos = i;
        }
        return lastPos == 0;
    }
}