package bishi.jianhang;

import java.util.Scanner;

public class P1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        s = s.substring(1, s.length() -1);
        String[] ss = s.split(",");
        Integer[] nums = new Integer[ss.length];
        for (int i = 0; i < ss.length; i++) {
            nums[i] = Integer.parseInt(ss[i]);
        }
        change(nums);
    }

    public static void change(Integer[] nums){
        int five = 0, ten = 0;
        for(int num : nums){
            if(num == 5){
                five++;
            }else if(num == 10){
                if(five == 0){
                    System.out.println(false);
                    return;
                }else{
                    ten++;
                    five--;
                }
            }else{
                if(five==0 || (ten == 0 && five < 3)){
                    System.out.println(false);
                    return;
                }else if(ten > 0 && five > 0){
                    five--;
                    ten--;
                }else if(ten==0 && five >= 3){
                    five -= 3;
                }
            }
        }
        System.out.println(true);
    }

}
