package intelligent;

import java.util.Arrays;

/**
 * @author fubic
 * @date 2021-05-19
 */
public class Solution56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        int[][] res = new int[intervals.length][2];
        int idx = -1;
        for(int[] interval : intervals){
            if(idx == -1 || res[idx][1] < interval[0]){
                res[++idx] = interval;
            }else{
                res[idx][1] = Math.max(res[idx][1], interval[1]);
            }
        }
        return Arrays.copyOf(res, idx + 1);
    }

}
