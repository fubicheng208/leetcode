package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
        示例 1：
        输入：nums = [2,7,11,15], target = 9
        输出：[2,7] 或者 [7,2]*/

public class M57 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i< nums.length; i++){
            if(hm.containsKey(nums[i])){
                return new int[]{nums[i], target - nums[i]};
            }
            hm.put(target - nums[i], i);
        }
        return new int[]{};
    }
}
