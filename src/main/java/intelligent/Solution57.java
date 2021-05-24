package intelligent;

import java.util.Arrays;

/**
 * @author fubic
 * @date 2021-05-24
 */
public class Solution57 {

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int idx;
        if(intervals == null || intervals.length == 0){
            if(newInterval == null || newInterval.length == 0){
                return intervals;
            }else{
                idx = 0;
            }
        }else{
            idx = searchInsertIndex(intervals, newInterval[0]);
        }


        int[][] res = new int[intervals.length + 1][2];
        System.arraycopy(intervals, 0, res, 0, idx);
        res[idx][0] = newInterval[0];
        res[idx][1] = newInterval[1];
        System.arraycopy(intervals, idx, res, idx + 1, intervals.length - idx);

        int[][] ret = new int[res.length][2];
        ret[0][0] = res[0][0];
        ret[0][1] = res[0][1];
        int k = 0;
        for(int i = 0; i < res.length; i++){
            if(ret[k][1] < res[i][0]){
                ret[++k][0] = res[i][0];
                ret[k][1] = res[i][1];
            }else{
                ret[k][1] = Math.max(res[i][1], ret[k][1]);
            }
        }
        return Arrays.copyOf(ret, k + 1);
    }

    public static int searchInsertIndex(int[][] intervals, int k){
        int l = 0, r = intervals.length - 1;
        while(l < r){
            int mid = (l + r) >>> 1;
            if(k <= intervals[mid][0]){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        for(int[] a : insert(new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}}, new int[]{4,8})){
            System.out.println(a[0] + " " + a[1]);
        }
/*        for(int[] a : insert(new int[][]{{1,3}, {6, 9}}, new int[]{2,5})){
            System.out.println(a[0] + " " + a[1]);
        }*/
    }
}
