package bishi.yinke;

public class P4 {
    /**
     * @param a int整型一维数组 升序数组
     * @param b int整型一维数组 升序数组
     * @return int整型一维数组
     */
    public int[] Merge(int[] a, int[] b) {
        int[] res = new int[a.length + b.length];
        int p1 = 0, p2 = 0, p = 0;
        while (p1 < a.length && p2 < b.length) {
            res[p++] = a[p1] < b[p2] ? a[p1++] : b[p2++];
        }
        if (p1 < a.length) {
            System.arraycopy(a, p1, res, p, a.length - p1);
        } else {
            System.arraycopy(b, p2, res, p, b.length - p2);
        }
        return res;
    }
}
