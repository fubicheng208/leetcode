package bishi.wyAndroid;

import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int len = s.length(), res = 0;
        for (int i = 0; i < 2 * len - 1 ; i++) {
            int l = i /2 , r = i / 2 + i % 2;
            while(l >= 0 && r < len && s.charAt(l) == s.charAt(r)){
                if(l != r){
                    ++res;
                }
                l--;
                r++;
            }
        }
        System.out.println(res);
    }
}
