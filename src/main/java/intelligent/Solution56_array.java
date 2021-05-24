package intelligent;

/**
 * @author fubic
 * @date 2021-05-24
 */
public class Solution56_array {
    public int[][] merge(int[][] intervals){
        if(intervals == null || intervals.length <= 1){
            return intervals;
        }

        int[][] res = new int[intervals.length][2];
        res[0][0] = intervals[0][0];
        res[0][1] = intervals[0][1];
        int k = 0;
        for(int i = 1; i < intervals.length; i++){
            if(res[k][1] < intervals[i][0]){
                res[++k][0] = intervals[i][0];
                res[++k][1] = intervals[i][1];
            }else{
                res[k][1] = Math.max(res[k][1], intervals[i][1]);
            }
        }
        return res;
    }
}
