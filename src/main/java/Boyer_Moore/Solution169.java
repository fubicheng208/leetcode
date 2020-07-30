package Boyer_Moore;

public class Solution169 {
    //Boyer-Moore 投票算法
    public int majorityElement(int[] nums) {
        int cnt = 0;
        int candidate = 0;
        for (int n : nums) {
            if (cnt == 0) {
                candidate = n;
            }
            cnt += n == candidate ? 1 : -1;
        }
        return candidate;
    }
}
