package two_pointer;

/**
 * @author fubic
 * @date 2021-11-28
 */
public class Solution283 {

/*    给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

    示例:
    输入: [0,1,0,3,12]
    输出: [1,3,12,0,0]*/


    // 不保证相对顺序
    // public void moveZeroes(int[] nums) {
    //     int r = nums.length - 1;
    //     for(int i = 0; i <= r; i++){
    //         if(nums[i] == 0){
    //             nums[i] = nums[r];
    //             nums[r] = 0;
    //             r--;
    //             if(nums[i] == 0){
    //                 i--;
    //             }
    //         }
    //     }
    // }

    //
    public void moveZeroes(int[] nums) {
        int l = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[l++] = nums[i];
            }
        }

        for(int i = nums.length - 1; i >= l; i--){
            nums[i] = 0;
        }
    }
}
