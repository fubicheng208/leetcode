package array;

public class M39 {
/*    数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
    你可以假设数组是非空的，并且给定的数组总是存在多数元素。

    示例 1:
    输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
    输出: 2*/

    //摩尔投票
//    遇到与模拟众数相同的数，计数+1，不同-1；
    public int majorityElement(int[] nums) {
        int x = 0, tickets = 0;
        for (int num : nums) {
            if (tickets == 0)
                x = num;
            tickets += num == x ? 1 : -1;
        }
        return x;
    }
}
