package divide_conquer;

public class Solution169 {
    public static int majorityElement(int[] nums) {
        return majorityElement(nums, 0, nums.length - 1);
    }

    private static int majorityElement(int[] nums, int l, int r) {
        if (l == r)
            return nums[l];
        int mid = (l + r) >>> 1;
        //左边出现次数最多的元素，右边出现次数最多的元素
        int l_e = majorityElement(nums, l, mid);
        int r_e = majorityElement(nums, mid + 1, r);
        if (l_e == r_e)
            return l_e;
        int l_cnt = countInRange(nums, l_e, l, mid);
        int r_cnt = countInRange(nums, r_e, mid + 1, r);
        return l_cnt > r_cnt ? l_e : r_e;
    }

    private static int countInRange(int[] nums, int n, int l, int r) {
        int cnt = 0;
        for (int i : nums) {
            if (i == n)
                cnt++;
        }
        return cnt;
    }
}
