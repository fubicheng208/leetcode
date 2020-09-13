package bishi.sogou;

import java.util.HashSet;

public class P3 {

    HashSet<String> hs = new HashSet<>();

    public long getPasswordCount (String password) {
        // write code here
        int[] nums = new int[password.length()];
        int t = 0;
        for(char c : password.toCharArray()){
            nums[t++] = c - '0';
        }
        cal(nums, "0");
        cal(nums, "1");
        cal(nums, "2");
        cal(nums, "3");
        cal(nums, "4");
        cal(nums, "5");
        cal(nums, "6");
        cal(nums, "7");
        cal(nums, "8");
        cal(nums, "9");
        hs.remove(password);
        return (long)hs.size();
    }

    public void cal(int[] nums, String news){
        if(news.length() == nums.length){
            hs.add(news);
            return;
        }
        int k = news.length() - 1;
        int lastNum = news.charAt(k) - '0';
        int floor = (int)Math.floor((nums[k+1] + lastNum) / 2.0);
        int ceil = (int)Math.ceil((nums[k+1] + lastNum) / 2.0);
        cal(nums, news+ceil);
        if(floor != ceil){
            cal(nums, news + floor);
        }
    }
}
