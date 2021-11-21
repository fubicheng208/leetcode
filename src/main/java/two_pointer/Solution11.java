package two_pointer;

/**
 * @author fubic
 * @date 2021-11-21
 */
public class Solution11 {
/*    给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

    说明：你不能倾斜容器。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/container-with-most-water
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

    // 思路：实际上不是每步选择更大的，而是舍弃最小的
    // 因为若矮的边界留着，那下一步的面积只会更小
    public int maxArea(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }
        int l = 0;
        int r = height.length - 1;
        int max = Integer.MIN_VALUE;
        while(l < r){
            max = Math.max(max, (r - l) * Math.min(height[l], height[r]));
            if(height[l] < height[r]){
                l += 1;
            }else{
                r -= 1;
            }
        }
        return max;
    }
}
