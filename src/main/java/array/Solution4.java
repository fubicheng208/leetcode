package array;

import java.util.Arrays;

/**
 * @author fubic
 * @date 2021-05-22
 */
public class Solution4 {

    //Method1: sort O(nlogn)
/*    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null){
            throw new RuntimeException("input array null");
        }
        int[] nums = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, nums, 0, nums1.length);
        System.arraycopy(nums2, 0, nums, nums1.length, nums2.length);
        Arrays.sort(nums);
        int len = nums.length;
        if(len % 2 == 1){
            return nums[len/2] * 1.0;
        }else{
            return (nums[len/2 - 1] + nums[len/2]) / 2.0;
        }
    }*/

    //Method2: two pointer, time:O(m + n), space:O(1)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null){
            throw new RuntimeException("input array null");
        }
        int i1 = 0, i2 = 0;
        int n = nums1.length + nums2.length;
        int mid = 0;
        if((n & 1) == 1){
            for (int i = 0; i <= n/2; i++) {
                if( i2 >= nums2.length  || (i1 < nums1.length && nums1[i1] <= nums2[i2])){
                    if(i == n/2){
                        mid = nums1[i1];
                    }
                    i1++;
                }else{
                    if(i == n/2){
                        mid = nums2[i2];
                    }
                    i2++;
                }
            }
            return mid * 1.0;
        }else{
            for (int i = 0; i <= n/2; i++) {
                if( i2 >= nums2.length  || (i1 < nums1.length && nums1[i1] <= nums2[i2])){
                    if(i == n/2 - 1 || i == n/2){
                        mid += nums1[i1];
                    }
                    i1++;
                }else{
                    if(i == n/2 - 1 || i == n/2){
                        mid += nums2[i2];
                    }
                    i2++;
                }
            }
            return mid / 2.0;
        }
    }


}
