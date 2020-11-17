package maths;

public class M16 {
    //1. 奇数： res *= x
    //2. x *= x
    //3. n >> 1
    public double myPow(double x, int n) {
        if(x == 0){
            return 0;
        }
        long b = n;
        if(b < 0){
            x = 1 / x;
            b = -b;
        }
        double res = 1.0;
        while(b != 0){
            //奇数
            if((b & 1) == 1){
                res *= x;
            }
            x *= x;
            b = b >> 1;
        }
        return res;
    }
}
