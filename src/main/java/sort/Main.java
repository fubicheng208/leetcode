package sort;

import sun.rmi.server.InactiveGroupException;

public class Main {
    public static void main(String[] args) {
        String s = "192.169.168.1";
        String[] ss = s.split(".");
        int[] nums = new int[4];
        for(int i = 0; i < 4; i++) {
            nums[i] = Integer.parseInt(ss[i]);
        }
        System.out.println(Integer.toBinaryString(3));
    }

}
