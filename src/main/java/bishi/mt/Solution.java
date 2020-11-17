package bishi.mt;

import java.util.*;


public class Solution {
    /**
     *
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    //滑动窗口
    public int maxLength2 (int[] arr) {
        // write code here
        Set<Integer> set = new HashSet<>();
        int ans = 0, r = -1;
        int len = arr.length;
        //l为左窗口，r为右窗口
        for(int l = 0; l < len; l++){
            if(l != 0){
                set.remove(arr[l - 1]);
            }
            //一直增大窗口到出现重复，则开始缩小窗口
            while(r + 1 < len && !set.contains(arr[r + 1])){
                set.add(arr[r + 1]);
                r++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }

    //动态规划
    public int maxLength (int[] arr) {
        Map<Integer, Integer> m = new HashMap<>();
        int ans = 0;
        //以目前遍历到的数字为结尾的最长不重复序列长度
        int dp = 0;
        for(int j = 0; j < arr.length; j++){
            int i = m.getOrDefault(arr[j], -1);
            m.put(arr[j], j);
            if( dp < j - i){
                dp = dp + 1;//重复的数字在不重复序列之外，则+1
            } else{
                dp = j - i;//...之内，则=j-i;
            }
            ans = Math.max(ans, dp);
        }
        return ans;
    }

    public int maxLength3(int[] arr){
        Map<Integer, Integer> m = new HashMap<>();
        int ans = 0;
        int dp = 0;
        for(int j = 0; j < arr.length; j++){
            int i = m.getOrDefault(arr[j], -1);
            m.put(arr[j], j);
            if( dp < j - i){ //重复的数字在最长不重复序列之外
                dp = dp + 1;
            } else{
                dp = j - i; //重复的数字在最长不重复序列之内，则要更新dp
            }
            ans = Math.max(ans, dp);
        }
        return ans;
    }

}
