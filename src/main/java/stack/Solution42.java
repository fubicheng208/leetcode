package stack;

public class Solution42 {
    public static int trap(int[] height) {
        /*//从左往右找第一个不为0的下标
        int i;
        for(i=0; i < height.length; i++){
            if(height[i] != 0)
                break;
        }
        int j;
        //从右往左找第一个不为0的下标
        for(j = height.length - 1; j>=0; j++){
            if(height[j] != 0)
                break;
        }
        //初始的最高值
        int highest_l = height[i];
        int highest_r = height[j];
        if(highest_l == 0 && highest_r == 0)
            return 0;
        int area = 0;
        while(i <= j){
            area += (j - i + 1) * hi;

        }*/

        int area = 0;
        int i = 0, j = height.length - 1;
        int l_highest = 0, r_highest = 0;
        int pre = 0;//记录前一次的高度
        while (i < j) {
            if (l_highest <= r_highest) {
                while (i < j && height[i] <= l_highest)
                    i++;
            }
            if (r_highest <= l_highest) {
                while (j > i && height[j] <= r_highest)
                    j--;
            }
            area += (Math.min(height[i], height[j]) - pre) * (j - i + 1);
            pre = Math.min(height[i], height[j]);
            l_highest = height[i];
            r_highest = height[j];
        }
        int area_black = 0;
        for (int h : height) area_black += h;
        int area_blue = area - area_black;
        return area_blue > 0 ? area_blue : 0;
    }
}
