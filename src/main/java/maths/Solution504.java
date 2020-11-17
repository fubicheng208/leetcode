package maths;

public class Solution504 {
//    给定一个整数，将其转化为7进制，并以字符串形式输出。
    //参考Java toString(int i, int radix)的做法
    //1. num % radix
    //2. num /= radix
    public String convertToBase7(int num) {
        char[] digits = new char[]{'0', '1', '2', '3', '4', '5', '6'};
        //33是因为有符号int转化为2进制最长为32位，加符号即为33位
        char[] buf = new char[33];
        boolean negative = (num < 0);
        int charPos = 32;
        //同一转换为正数来处理
        if(negative){
            num = -num;
        }
        //这么做是为了解决0的特殊情况
        while(num >= 7){
            buf[charPos--] = digits[num % 7];
            num /= 7;
        }
        buf[charPos] = digits[num];
        if(negative){
            buf[--charPos] = '-';
        }
        //new String(char[], offset, length)
        return new String(buf, charPos, 33 - charPos);
    }


    //N进制转10进制
    //1. res = 0
    //2. res * radix + now
    public int toTenInt(String s, int radix){
        if(s == null || s.length() == 0 || radix < 2){
            throw new RuntimeException("");
        }
        boolean negative = false;
        int i = 0;
        if(s.charAt(0) == '-'){
            negative = true;
            i++;
        }
        int res = 0;
        for(;i < s.length(); i++){
            int num = (s.charAt(i) - '0');
            res = res * radix + num;
        }
        return negative ? -res : res;
    }
}
