package bishi.meituan;

import java.util.Arrays;
import java.util.Scanner;

public class P4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            if (n == 2){
                System.out.println("NO");
                continue;
            }
            int sum = Arrays.stream(a).sum();
            if(sum == 2*n - 1){
                if(Arrays.stream(a).anyMatch(t -> t==2)){
                    System.out.println("NO");
                }
                    System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
    }
}
