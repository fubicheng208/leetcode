package binary_search;

import java.lang.reflect.Array;
import java.util.Arrays;

/*给定两个数组，编写一个函数来计算它们的交集。

        示例 1:

        输入: nums1 = [1,2,2,1], nums2 = [2,2]
        输出: [2,2]*/
public class Solution350 {
    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int k = 0;
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length; ) {
            if (nums1[i] < nums2[j])
                i++;
            else if (nums1[i] > nums2[j])
                j++;
            else {
                nums1[k++] = nums1[i++];
                j++;
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }
}
