package bit_manipulation;

public class M56_1 {
//    一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
//
// 
//
//示例 1：
//
//输入：nums = [4,1,4,6]
//输出：[1,6] 或 [6,1]


    public int[] singleNumbers(int[] nums) {
        int ret = 0;
        int a = 0;
        int b = 0;
        for (int i : nums) {
            ret ^= i;
        }
        int h = 1;
        //找到右边第一位为1的
        while ((ret & h) == 0) {
            h <<= 1;
        }
        for (int i : nums) {
            if ((i & h) == 0) {
                a ^= i;
            } else
                b ^= i;
        }
        return new int[]{a, b};
    }
}
