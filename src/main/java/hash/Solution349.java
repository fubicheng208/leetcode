package hash;

import java.lang.reflect.Array;
import java.util.*;

public class Solution349 {
    public static int[] intersection(int[] nums1, int[] nums2) {
        //Hash筛选
       /* Set<Integer> set = new HashSet<Integer>();
        for(int n : nums1){
            set.add(n);
        }
        int[] res = new int[nums2.length];
        int idx = 0;
        for(int n : nums2){
            if(set.contains(n)){
                res[idx++] = n;
                set.remove(n);
            }
        }
        return Arrays.copyOf(res, idx);*/

        //内置函数
        Set<Integer> set1 = new HashSet<Integer>();
        for (int n : nums1) set1.add(n);

        Set<Integer> set2 = new HashSet<Integer>();
        for (int n : nums2) set2.add(n);

        set1.retainAll(set2);
        int[] res = new int[set1.size()];
        int idx = 0;
        for (int i : set1)
            res[idx++] = i;
        return Arrays.copyOf(res, idx);

    }
}
