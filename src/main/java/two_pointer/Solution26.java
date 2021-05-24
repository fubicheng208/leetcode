package two_pointer;

/**
 * @author fubic
 * @date 2021-05-22
 */
public class Solution26 {

/*    给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
    不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。

    示例 1：
    输入：nums = [1,1,2]
    输出：2, nums = [1,2]
    解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。*/


    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        int slow = 1, quick = 1; //quick寻找下一个不同数字的起始位置，slow记录复制后数据下标位置
        while(quick < nums.length){
            if(nums[quick - 1] != nums[quick]){
                nums[slow] = nums[quick];
                slow++;
            }
            quick++;
        }
        return slow;
    }

}
