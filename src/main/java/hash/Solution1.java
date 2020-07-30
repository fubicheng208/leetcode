package hash;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {
    public static int[] twoSum(int[] nums, int target) {
        //两遍Hash
        /*Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++)
            hm.put(nums[i], i);
        for(int i=0; i<nums.length; i++){
            int other = target - nums[i];
            if(hm.containsKey(other) && hm.get(other)!=i){
                return new int[]{i, hm.get(other)};
            }
        }
        return new int[]{-1, -1};*/

        //一遍Hash
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int other = target - nums[i];
            if (hm.containsKey(other))
                return new int[]{hm.get(other), i};
            hm.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
