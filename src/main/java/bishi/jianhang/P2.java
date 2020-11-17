package bishi.jianhang;

import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int[] res = new int[9];
        for(int i = 0; i < 3; i++){
            int t = a % 10;
            a /= 10;
            if(i == 0){
                res[6] = t;
            }else if(i == 1){
                res[3] = t;
            }else{
                res[0] = t;
            }
        }

        for(int i = 0; i < 3; i++){
            int t = b % 10;
            b /= 10;
            if(i == 0){
                res[7] = t;
            }else if(i == 1){
                res[4] = t;
            }else{
                res[1] = t;
            }
        }

        for(int i = 0; i < 3; i++){
            int t = c % 10;
            c /= 10;
            if(i == 0){
                res[8] = t;
            }else if(i == 1){
                res[5] = t;
            }else{
                res[2] = t;
            }
        }

        for(int n : res){
            System.out.print(n);
        }
        System.out.println();
    }
}
