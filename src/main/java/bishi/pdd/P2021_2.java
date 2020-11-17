package bishi.pdd;

import java.util.*;

public class P2021_2 {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> ls = new ArrayList<>();
        int M;
        int[] data = new int[6];
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < 6; j++) {
                data[j] = sc.nextInt();
            }
            int tmp = cal(data);
        }
    }

    public static void up(int[] data){
        int[] tmp = new int[6];
        for (int i = 0; i < 6; i++) {
            tmp[i] = data[i];
        }
        data[0] = tmp[4];
        data[1] = tmp[5];
        data[4] = tmp[1];
        data[5] = tmp[0];
    }

    public static void right(int[] data){
        int[] tmp = new int[6];
        for (int i = 0; i < 6; i++) {
            tmp[i] = data[i];
        }
        data[2] = tmp[5];
        data[4] = tmp[2];
        data[3] = tmp[4];
        data[5] = tmp[3];
    }

    public static void front(int[] data){
        int[] tmp = new int[6];
        for (int i = 0; i < 6; i++) {
            tmp[i] = data[i];
        }
        data[2] = tmp[5];
        data[4] = tmp[2];
        data[3] = tmp[4];
        data[5] = tmp[3];
    }

    public static int cal(int[] data){
        int age = 1;
        int ans = 0;
        for (int i = 0; i < 6; i++) {
            ans += age * data[i];
            age *= 10;
        }
        return ans;
    }
}
