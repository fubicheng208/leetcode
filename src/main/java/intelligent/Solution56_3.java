package intelligent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author fubic
 * @date 2021-05-23
 */
public class Solution56_3 {

    public List<List<Integer>> merge(List<List<Integer>> intervals){
        if(intervals == null || intervals.size() <= 1){
            return intervals;
        }
        Collections.sort(intervals, (l1,l2)->l1.get(0) - l2.get(0));
        int k = 0;
        List<List<Integer>> res = new ArrayList<>();
        res.add(intervals.get(0));
        for(List<Integer> v : intervals){
            List<Integer> resV = res.get(k);
            if(resV.get(1) < v.get(0)){
                res.add(v);
                k++;
            }else{
                resV.set(1, Math.max(resV.get(1), v.get(1)));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution56_3 c = new Solution56_3();
        List<List<Integer>> ls = new ArrayList<>();
        List<Integer> ls1 = new ArrayList<>();
        ls1.add(1);
        ls1.add(3);

        List<Integer> ls2 = new ArrayList<>();
        ls2.add(2);
        ls2.add(6);

        List<Integer> ls3 = new ArrayList<>();
        ls3.add(8);
        ls3.add(10);

        List<Integer> ls4 = new ArrayList<>();
        ls4.add(15);
        ls4.add(18);

        ls.add(ls1);
        ls.add(ls2);
        ls.add(ls3);
        ls.add(ls4);
        System.out.println(c.merge(ls));
    }

}
