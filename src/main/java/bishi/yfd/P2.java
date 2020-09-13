package bishi.yfd;

import java.util.Scanner;

public class P2  {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            String[] ss = s.split(" +-*");
            for(String t : ss){
                System.out.println(t);
            }
            System.out.println();
        }
    }
}
