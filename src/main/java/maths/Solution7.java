package maths;

public class Solution7 {
    public static int reverse(int x) {
/*//        不处理溢出做法
        int flag = 1;
        if(x<0){
            x = -1*x;
            flag = -1;
        }
        String s = x+"";
        int len = s.length();
        int n = len;
        int res = 0;
        for(int i=1; i<=n; i++){
            int num = x/(int)Math.pow(10, len-i);
            res += num * (int)Math.pow(10, i-1);
            x -= num * (int)Math.pow(10, len-i);
        }
        return res*flag;
        //1534236469*/
        int res = 0;
        while (x != 0) {
            int pop = x % 10;
            x = x / 10;
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && pop > 7))
                return 0;
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && pop < -8))
                return 0;
            res = res * 10 + pop;
        }
        return res;
    }
}