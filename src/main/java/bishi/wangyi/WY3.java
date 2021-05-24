package bishi.wangyi;

import java.util.Arrays;
import java.util.Scanner;

public class WY3 {
    static int[] b;
    static int res = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- != 0) {
            int n = sc.nextInt();
            b = new int[n];
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            Arrays.sort(a);
            try {
                bfs(a, 0);
            } catch (RuntimeException e) {
                System.out.println(res);
            }
        }
    }

    public static void bfs(int[] num, int begin) {
        if (begin == num.length)
            return;
        b[begin] = 1;

        if (canPartition(findNoJudge(num))) {
            int tmp = 0;
            for (int i = 0; i < num.length; i++) {
                if (b[i] == 1)
                    tmp += num[i];
            }
            res = tmp;
            throw new RuntimeException("");
        }
        for (int i = begin; i < num.length; i++) {
            bfs(num, i + 1);
        }
        b[begin] = 0;
    }

    public static int[] findNoJudge(int[] num) {
        int zeros = (int) Arrays.stream(b).filter(i -> i == 0).count();
        int[] res = new int[zeros];
        for (int i = 0, j = 0; i < num.length; i++) {
            if (b[i] == 0)
                res[j++] = num[i];
        }
        return res;
    }

    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums) sum += i;
        if (sum % 2 != 0) return false;
        sum /= 2;
        boolean dp[] = new boolean[sum + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int i = sum; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }
        return dp[sum];
    }


}
