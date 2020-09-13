package bishi.wyAndroid;

import java.util.Scanner;

public class P4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] ss = s.split(" ");
        Integer[] is = new Integer[ss.length];
        for (int i = 0; i < ss.length; i++) {
            is[i] = Integer.parseInt(ss[i]);
        }
        int[] dp = {0,0,0,0,0,0,0};
        for (int i = 0; i < is.length; i++) {
            int mod = is[i] % 7;

            int a0 = dp[(7 + 0 - mod) % 7];
            int a1 = dp[(7 + 1 - mod) % 7];
            int a2 = dp[(7 + 2 - mod) % 7];
            int a3 = dp[(7 + 3 - mod) % 7];
            int a4 = dp[(7 + 4 - mod) % 7];
            int a5 = dp[(7 + 5 - mod) % 7];
            int a6 = dp[(7 + 6 - mod) % 7];

            if(a0 != 0 || mod == 0){
                dp[0] = Math.max(dp[0], a0 + is[i]);
            }
            if(a1 != 0 || mod == 1){
                dp[1] = Math.max(dp[1], a1 + is[i]);
            }
            if(a2 != 0 || mod == 2){
                dp[2] = Math.max(dp[2], a2 + is[i]);
            }
            if(a3 != 0 || mod == 3){
                dp[3] = Math.max(dp[3], a3 + is[i]);
            }
            if(a4 != 0 || mod == 4){
                dp[4] = Math.max(dp[4], a4 + is[i]);
            }
            if(a5 != 0 || mod == 5){
                dp[5] = Math.max(dp[5], a5 + is[i]);
            }
            if(a6 != 0 || mod == 6){
                dp[6] = Math.max(dp[6], a6 + is[i]);
            }
        }
        System.out.println(dp[0]);
    }
}
