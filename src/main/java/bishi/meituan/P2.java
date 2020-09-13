package bishi.meituan;

import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        int low = 0;
        int hi = 0;
        for (char c : s.toCharArray()){
            if(c >= 'a'){
                low++;
            }else{
                hi++;
            }
        }
        System.out.println(s.length()/2 - Math.min(low, hi));

    }
}
