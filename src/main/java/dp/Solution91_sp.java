package dp;

import java.util.Scanner;

public class Solution91_sp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();
        String s = "";
        for (Character c : in.toCharArray()) {
            s += c - 'A';
        }
//        System.out.println(s);

        int length = s.length();
        if (length == 0 || length == 1) {
            System.out.println("0");
            return;
        }

        int[] dp = new int[length];
        dp[0] = 1;

        int tmp = Integer.parseInt(s.charAt(0) + "" + s.charAt(1));
        if (tmp >= 26 || tmp < 10)
            dp[1] = 1;
        else
            dp[1] = 2;

        for (int i = 2; i < length; i++) {
            int num = Integer.parseInt(s.charAt(i - 1) + "" + s.charAt(i));
            if (num >= 26 || num < 10)
                dp[i] = dp[i - 1];
            else
                dp[i] = dp[i - 1] + dp[i - 2];
        }
        System.out.println(dp[length - 1] - 1);
    }
}
