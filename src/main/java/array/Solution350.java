package array;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution350 {
/*    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> ls1 = new ArrayList<>();
        for(int i = 0; i< nums1.length; i++){
            ls1.add(nums1[i]);
        }

        List<Integer> ls2 = new ArrayList<>();
        for(int i = 0; i< nums2.length; i++){
            ls2.add(nums2[i]);
        }

        ls1.retainAll(ls2);
        ls2.retainAll(ls1);
        int[] res = new int[ls2.size()];
        for (int i = 0; i < ls2.size(); i++) {
            res[i] = ls2.get(i);
        }
        return res;
    }*/

    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int num : nums1) {
            int cnt = hm.getOrDefault(num, 0);
            hm.put(num, cnt + 1);
        }
        List<Integer> tmp = new ArrayList<>();
        for (int num : nums2) {
            int cnt = hm.getOrDefault(num, 0);
            if (cnt != 0) {
                if (cnt > 1) {
                    hm.put(num, cnt - 1);
                } else {
                    hm.remove(num);
                }
                tmp.add(num);
            }
        }
        int[] res = new int[tmp.size()];
        for (int i = 0; i < tmp.size(); i++) {
            res[i] = tmp.get(i);
        }
        return res;
    }
/*    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int k = 0;
        for(int i=0, j=0; i< nums1.length && j < nums2.length; ){
            if(nums1[i]<nums2[j])
                i++;
            else if(nums1[i]>nums2[j])
                j++;
            else{
                nums1[k++] = nums1[i++];
                j++;
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }*/


    public static void main(String[] args) {
        new Solution350().intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2});
    }
}
