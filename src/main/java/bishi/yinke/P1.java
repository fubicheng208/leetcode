package bishi.yinke;

public class P1 {
    /**
     * 是否可以到达
     *
     * @param nums int整型一维数组 保存可移动步长的数组
     * @return bool布尔型
     */
/*    public boolean canJump (int[] nums) {
        int fastest = -1;
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            if(fastest < num){
                return false;
            }
            fastest = Math.max(i + num, fastest);
        }
        return true;
    }*/
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int fastest = nums[0];
        for (int i = 0; i <= fastest; i++) {
            fastest = Math.max(fastest, i + nums[i]);
            if (fastest >= n) {
                return true;
            }
        }
        return false;
    }
}
