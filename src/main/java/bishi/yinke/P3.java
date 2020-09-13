package bishi.yinke;

import linked_list.ListNode;

public class P3 {
    /**
     *
     * @param s int整型
     * @param nums int整型一维数组
     * @return int整型
     */
    public int MinsubListLen (int s, int[] nums) {
        // write code here
        int n = nums.length;
        if(n == 0){
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int l = 0, r = 0;
        int sum = 0;
        while(r < n){
            sum += nums[r];
            while(sum >= s){
                ans = Math.min(ans, r - l + 1);
                sum -= nums[l];
                l++;
            };
            r++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
