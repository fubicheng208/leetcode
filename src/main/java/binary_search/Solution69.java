package binary_search;

public class Solution69 {
    public static int mySqrt(int x) {
        long l = 0;
        long r = x / 2 + 1;
        while (l < r) {
            long mid = (l + r + 1) >>> 1;
            long square = mid * mid;
            if (square > x)
                r = mid - 1;
            else
                l = mid;
        }
        return (int) l;
    }
}
