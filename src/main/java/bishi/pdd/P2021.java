package bishi.pdd;

import java.util.Scanner;

public class P2021 {
    public static void main(String[] args) {
        int d, t;
        Scanner scanner = new Scanner(System.in);
        d = scanner.nextInt();
        t = scanner.nextInt();
        if (d == 0) {
            System.out.println("paradox");
            return;
        }
        int[] scores = new int[t];
        for (int i = 0; i < t; i++) {
            scores[i] = scanner.nextInt();
        }
        int returnTimes = 0;
        for (int score : scores) {
            if (d - score == 0) {
                System.out.println("paradox");
                return;
            } else if (d - score < 0) {
                d = score - d;
                returnTimes++;
            } else {
                d = d - score;
            }
        }
        System.out.println(d + " " + returnTimes);
    }
}
