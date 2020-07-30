package maths;

public class Solution50 {

//    实现 pow(x, n) ，即计算 x 的 n 次幂函数。
//
//    示例 1:
//
//    输入: 2.00000, 10
//    输出: 1024.00000

    //普通方法，超时
//    public double myPow(double x, int n) {
//        if(n==0)
//            return 1.0;
//        boolean neg = false;
//        if(n < 0){
//            neg = true;
//            n = -n;
//        }
//        double res = 1;
//        for(int i=0; i<n; i++){
//            res *= x;
//        }
//        return neg? 1/res : res;
//    }

    //快速幂
    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1 / quickMul(x, -N);
    }

//    //法二：递归
//    public double quickMul(double x, long n){
//        if(n==0)
//            return 1.0;
//        double y = quickMul(x, n / 2);
//        return n % 2 == 0 ? y * y : y * y * x;
//    }


    //法三：迭代
    //关键点：在于奇数次中的x之后会被迭代多次，比如x77中x9->x19中的x之后仍然被迭代了两次
    public double quickMul(double x, long n) {
        double ans = 1.0;
        //x的贡献会被迭代
        double x_c = x;
        while (n > 0) {
            //最低位为1迭代计入贡献
            if (n % 2 == 1)
                ans *= x_c;
            x_c *= x_c;
            n /= 2;
        }
        return ans;
    }
}
