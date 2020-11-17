package bishi.pdd;

import java.util.Scanner;

public class P2020 {
/*    多多鸡有N个魔术盒子（编号1～N），其中编号为i的盒子里有i个球。
    多多鸡让皮皮虾每次选择一个数字X（1 <= X <= N），多多鸡就会把球数量大于等于X个的盒子里的球减少X个。
    通过观察，皮皮虾已经掌握了其中的奥秘，并且发现只要通过一定的操作顺序，可以用最少的次数将所有盒子里的球变没。
    那么请问聪明的你，是否已经知道了应该如何操作呢？*/

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            System.out.println(calTimes(num));
        }
    }

    public static int calTimes(int num){
        if(num == 1)
            return 1;
        if(num == 2)
            return 2;
        return 1 + calTimes(num/2);
    }


}
