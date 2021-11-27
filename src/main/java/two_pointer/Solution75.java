package two_pointer;

/**
 * @author fubic
 * @date 2021-11-27
 */
public class Solution75 {
//    给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
//    此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
//
//    输入：nums = [2,0,2,1,1,0]
//    输出：[0,0,1,1,2,2]

    //整体思路： 0换到前面，2换到最后
    public void sortColors(int[] nums) {
        int l = 0, r = nums.length - 1;
        for(int i =0 ; i <= r; i++){
            if(nums[i] == 0){
                nums[i] = nums[l];
                nums[l] = 0;
                l++;
            }
            if(nums[i] == 2){
                nums[i] = nums[r];
                nums[r] = 2;
                r--;
                // nums[i] == 0不需要，因为0换到最前面，肯定就OK了
                // 但如果是2,nums[2] = 0/2, 则下一次需要继续换这个位置
                if(nums[i] != 1){
                    i--;
                }
            }
        }
    }
}
