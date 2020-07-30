package bit_manipulation;

public class Solution191 {
    //    编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
//    示例 1：
//    输入：00000000000000000000000000001011
//    输出：3
//    解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
    public int hammingWeight(int n) {
        int nums = 0;
        while (n != 0) {
            n = n & (n - 1);
            nums++;
        }
        return nums;
    }
}
