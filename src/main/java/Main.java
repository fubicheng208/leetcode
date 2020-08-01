import sun.nio.cs.ext.MacHebrew;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {


        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] work = new int[n];
        int[] sport = new int[n];
        for (int i = 0; i < n; i++) {
            work[i] = s.nextInt();
        }
        for (int i = 0; i < n; i++) {
            sport[i] = s.nextInt();
        }


        //输出正确：4; 1 1 0 0； 0 1 1 0;
        //输出错误：5; 1 0 1 1 0; 1 0 1 0 1;
        System.out.println(get_min_rest(work, sport, 0));


    }

    public static int get_min_rest(int work[], int sport[], int now) {
        int n = work.length;
        if (now == n)
            return 0;
        int rest_cnt_work_1st_day = 0;
        int pre = 0;//前一次选择是工作（0），健身（1）
        boolean has_pre = false;
        for (int i = now + 1; i < n; i++) {
            //如果已经隔了一天，且这天既可以去工作也可以去健身
            if (!has_pre && i != 0 && work[i] == 1 && sport[i] == 1) {
                rest_cnt_work_1st_day += get_min_rest(work, sport, i);
                break;
            }
            if (i == 0)
                has_pre = true;
            //如果前一天选择的是工作
            if (has_pre && pre == 0) {
                //只要第二天可以运动，就去运动
                if (sport[i] == 1) {
                    has_pre = true;
                    pre = 1;
                    continue;
                } else {
                    has_pre = false;
                    rest_cnt_work_1st_day++;
                }
            } else if (has_pre && pre == 1) {//如果前一天健身房
                if (work[i] == 1) {
                    has_pre = true;
                    pre = 0;
                    continue;
                } else {
                    has_pre = false;
                    rest_cnt_work_1st_day++;
                }
            } else {
                rest_cnt_work_1st_day++;
            }
        }

        //第一天选择的是健身
        int rest_cnt_sport_1st_day = 0;
        has_pre = false;
        pre = 1;//前一次选择是工作（0），健身（1）
        for (int i = now + 1; i < n; i++) {
            //如果已经隔了一天，且这天既可以去工作也可以去健身
            if (!has_pre && i != 0 && work[i] == 1 && sport[i] == 1) {
                rest_cnt_sport_1st_day += get_min_rest(work, sport, i);
                break;
            }
            if (i == 0)
                has_pre = true;
            //如果前一天选择的是工作
            if (has_pre && pre == 0) {
                if (sport[i] == 1) {
                    has_pre = true;
                    pre = 1;
                    continue;
                } else {
                    has_pre = false;
                    rest_cnt_sport_1st_day++;
                }
            } else if (has_pre && pre == 1) {//如果前一天健身房
                if (work[i] == 1) {
                    has_pre = true;
                    pre = 0;
                    continue;
                } else {
                    has_pre = false;
                    rest_cnt_sport_1st_day++;
                }
            } else {
                rest_cnt_sport_1st_day++;
            }
        }
        return Math.min(rest_cnt_sport_1st_day, rest_cnt_work_1st_day);
    }
}