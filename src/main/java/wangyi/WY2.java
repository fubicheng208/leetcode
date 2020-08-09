package wangyi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WY2 {
    public static void main(String[] args) {
        List<Integer> ls = new ArrayList<>();
        int[] exist = new int[100100];
        int n, m;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int tmp;
        for (int i = 0; i < m; i++) {
            tmp = sc.nextInt();
            ls.add(tmp);
            exist[tmp] = 1;
        }
        boolean first = true;
        int pos = 0;
        for (int i = 1; i <= n ; i++) {
            if(exist[i] == 1){
                continue;
            }
            while(pos < ls.size() && ls.get(pos) < i){
                if(first){
                    first = false;
                }
                else{
                    System.out.printf(" ");
                }
                System.out.printf(""+ls.get(pos++));
            }
            if(first)
                first = false;
            else
                System.out.printf(" ");
            System.out.printf(i+"");
        }
        while(pos < ls.size()){
            if(first)
                first = false;
            else
                System.out.printf(" ");
            System.out.printf(""+ls.get(pos++));
        }
        System.out.println();
    }
}
