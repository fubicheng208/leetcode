package maths;

public class M44 {
/*    数字以0123456789101112131415…的格式序列化到一个字符序列中。
    在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
    请写一个函数，求任意第n位对应的数字。
    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof*/

    public int findNthDigit(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        //1.找到n是所在的范围区间的第几位，如15中的5是,10-99中101112131415..中的第12位
        while(n > count){
            n -= count;
            digit++;
            start *= 10;
            count = digit * start * 9;
        }
        //2. 求出n所在的数字
        long num = start + (n - 1) / digit;
        //3. 求出该数字中n对应的那一位
        return Long.toString(num).charAt((n - 1) % digit) - '0';
    }
}
