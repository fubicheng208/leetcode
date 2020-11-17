package maths;

public class M43 {

/*    输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
    例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof*/

    public int countDigitOne(int n) {
        int digit = 1, res = 0;
        int high = n / 10, cur = n % 10, low = 0;
        //当high和cur同时为0时说明全为low,即已越界
        while(high != 0 || cur != 0){
            if(cur == 0){
                res += high * digit;
            }else if(cur == 1){
                res += high * digit + low + 1;
            }else{
                res += (high + 1) * digit;
            }
            low += cur * digit;
            cur = high % 10;
            high = high / 10;
            digit = digit * 10;
        }
        return res;
    }
}
