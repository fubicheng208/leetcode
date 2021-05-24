package array;

public class Solution169 {
/*    给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
    你可以假设数组是非空的，并且给定的数组总是存在多数元素。
    示例 1:
    输入: [3,2,3]
    输出: 3*/

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
