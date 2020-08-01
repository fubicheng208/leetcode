package bit_manipulation;

public class M65 {
    //写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
    //位运算思路
    //使用a ^ b 计算加
    //使用（a & b） << 1 计算进位
    public int add(int a, int b) {
        while(b != 0){
            int c = (a & b) << 1;
            a = a ^ b;
            b = c;
        }
        return a;
    }
}
