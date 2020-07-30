package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 3)
            return res;
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length - 3; i++) {
            if (nums[i] > 0)
                return res;
            if (i > 0 && nums[i] == nums[i - 1]) //若nums[i]==nums[i-1]，则nums[i-1]构成的三元组肯定已经包含nums[i]的三元组，
                continue;
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                if (nums[i] + nums[l] + nums[r] > 0)
                    r--;
                else if (nums[i] + nums[l] + nums[r] < 0)
                    l++;
                else {
                    List<Integer> ls = new ArrayList<Integer>();
                    ls.add(nums[i]);
                    ls.add(nums[l]);
                    ls.add(nums[r]);
                    res.add(ls);
                    //不包含重复三元组
                    while (l < r && nums[l] == nums[l + 1])
                        l++;
                    while (l < r && nums[r] == nums[r - 1])
                        r--;
                    l++;
                    r--;
                }
            }
        }
        return res;
    }
}
