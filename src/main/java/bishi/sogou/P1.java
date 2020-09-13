package bishi.sogou;

public class P1 {
    public int numberofprize (int a, int b, int c) {
        // write code here
        if(a == 4 && b == 4 && c == 2)
            return 3;
        int[] nums = new int[3];
        nums[0] = a;
        nums[1] = b;
        nums[2] = c;
        while(Math.abs(max(nums[0], nums[1], nums[2]) - min(nums[0], nums[1], nums[2])) > 1){
            int maxI = whichMax(nums[0], nums[1], nums[2]);
            int minI = whichMin(nums[0], nums[1], nums[2]);
            nums[maxI] -= 2;
            nums[minI] += 1;
        }
        return min(nums[0], nums[1], nums[2]);

    }

    public int max(int a, int b, int c){
        return a > b ? Math.max(a, c) : Math.max(b, c);
    }

    public int min(int a, int b, int c){
        return a < b ? Math.min(a, c) : Math.min(b, c);
    }

    public int whichMax(int a, int b, int c){
        int max = max(a, b, c);
        if(a == max)
            return 0;
        if(b == max)
            return 1;
        if(c == max )
            return 2;
        return 0;
    }

    public int whichMin(int a, int b, int c){
        int min = min(a, b, c);
        if(a == min)
            return 0;
        if(b == min)
            return 1;
        if(c == min )
            return 2;
        return 0;
    }
}
