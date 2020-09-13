package binary_search;

public class M53 {
    public int search(int[] nums, int target) {
        return helper(nums, target) - helper(nums, target - 1);
    }

    //返回tar所在区间的右端点
    int helper(int[] nums, int tar){
        int l = 0, r = nums.length - 1;
        while(l <= r){
            int m = (l + r) / 2;
            if(nums[m] <= tar)
                l = m + 1;
            else
                r = m - 1;
        }
        return l;
    }

}

