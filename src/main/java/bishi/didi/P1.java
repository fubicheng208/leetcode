package bishi.didi;


import java.util.Scanner;

public class P1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String s = sc.nextLine();
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < s.length() / n + 1; i++) {
            StringBuilder tmp = new StringBuilder("");
            tmp.append(s.substring(i * n, Math.min(i * n + n, s.length())));
            sb.append(tmp.reverse().toString());
        }
        System.out.println(sb.toString());
    }
}
