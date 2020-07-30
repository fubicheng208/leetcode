package maths;

public class Solution190 {
    // you need treat n as an unsigned value
    public static int reverseBits(int n) {
        /*//未AC原因：题意00000010100101000001111010011100 =》 00111001011110000010100101000000； 而在代码中=》00000000111001011110000010100101
        //也就是必须按整个32位来颠倒，0000000000000000000000000000010 =》01000000000000000000000000000000而不是00000000000000000000000000000001;
        int flag = 1;
        if(n<0){
            n = -1*n;
            flag = -1;
        }
        int ret = 0;
        while(n!=0){
            int pop = n%2;
            n=n/2;
            ret = ret*2 + pop;
        }
        return ret*flag;*/

        int ans = 0;
        //必须为无符号右移，若有符号右移会导致死循环；
        for (int bitsSize = 31; n != 0; bitsSize--, n = n >>> 1) {
            ans += (n & 1) << bitsSize;
        }
        return ans;
    }
}
