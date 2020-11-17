package bishi.wangyi;

import java.util.Scanner;

public class WY1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] a = new long[n];
        for(int i=0; i<n; i++){
            a[i] = sc.nextLong();
        }
        long res = 0;
        for(long num : a){
            res += count(num);
        }
        System.out.println(res);
    }

    public static long count(long num){
//        long cnt = 0;
        if(num  == 1){
            return 0;
        }else if(num == 2 || num == 3){
            return 1;
        }else{
            /*while(num > 3){
                num -= 2;
                cnt++;
            }
            cnt++;*/
            return num/2;
        }
    }
}
