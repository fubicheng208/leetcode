package dp;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author fubic
 * @date 2020/12/3
 */
public class M10 {
/*    一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
    答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。

    示例 1：
    输入：n = 2
    输出：2

    示例 2：
    输入：n = 7
    输出：21*/

    //动规
/*    public int numWays(int n) {
        int[] dp = new int[n+3];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        if(n < 3){
            return dp[n];
        }
        for(int i = 3; i <= n; i++){
            dp[i] = dp[i-1] % 1000000007  + dp[i-2] % 1000000007;
        }
        return dp[n] % 1000000007;
    }*/

    //递归
/*    public int numWays(int n) {
        if(n == 0){
            return 1;
        }
        return steps(n);
    }

    public int steps(int n){
        if(n == 1){
            return 1;
        }else if(n == 2){
            return 2;
        }
        return (steps(n-1) + steps(n-2)) % 1000000007;
    }*/

    Map<Integer, Integer> hm = new HashMap<>();

    //递归优化
    public int numWays(int n) {
        if(n == 0){
            return 1;
        }
        hm.put(1,1);
        hm.put(2,2);
        return steps(n);
    }

/*    public int steps(int n){
        if(hm.containsKey(n)){
            return hm.get(n);
        }
        int t = (steps(n - 1) + steps(n - 2)) % 1000000007;
        hm.put(n, t);
        return t;
    }*/

    //7n的台阶不能跳
    public int steps(int n){
        if(hm.containsKey(n)){
            return hm.get(n);
        }
        int t;
        if((n - 1) % 7 == 0){
            t = steps(n - 2);
        }else if((n - 2) % 7 == 0){
            t = steps(n - 1);
        }else{
            t = (steps(n - 1) + steps(n - 2)) % 1000000007;
        }
        hm.put(n, t);
        return t;
    }
}
