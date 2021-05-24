package bishi.yfd;

import java.util.Random;
import java.util.Scanner;

public class P3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            Random random = new Random();
            System.out.println((int) random.nextInt(2));
        }
    }
}
