package intelligent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author fubic
 * @date 2021-05-23
 */
public class Solution56_2 {

    static class Range{
        int a;
        int b;

        public Range() {
        }

        public Range(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public List<Range> merge(List<Range> intervals) {
        if(intervals == null || intervals.size() <= 1){
            return intervals;
        }
        Collections.sort(intervals, (v1, v2) -> v1.a - v2.a);
        List<Range> res = new ArrayList<>();
        res.add(intervals.get(0));
        int k = 0;
        for (Range v : intervals){
            Range resV = res.get(k);
            if(v.a > resV.b){
                res.add(v);
                k++;
            }else{
                resV.b = Math.max(v.b, resV.b);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution56_2 c = new Solution56_2();
        List<Range> ls = new ArrayList<>();
        ls.add(new Range(1,3));
        ls.add(new Range(2,6));
        ls.add(new Range(8,10));
        ls.add(new Range(15,18));
        for(Range v : c.merge(ls)){
            System.out.println(v.a + " : " + v.b);
        }
    }
}
