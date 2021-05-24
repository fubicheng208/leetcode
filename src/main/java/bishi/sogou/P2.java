package bishi.sogou;

public class P2 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 返回能创建的房屋数
     *
     * @param t  int整型 要建的房屋面宽
     * @param xa int整型一维数组 已有房屋的值，其中 x0 a0 x1 a1 x2 a2 ... xi ai 就是所有房屋的坐标和房屋面宽。 其中坐标是有序的（由小到大）
     * @return int整型
     */
    public static int getHouses(int t, int[] xa) {
        // write code here
        if (xa == null || xa.length == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i + 2 < xa.length; i += 2) {
            int l = xa[i] + xa[i + 1] / 2;
            int r = xa[i + 2] - xa[i + 3] / 2;
//            if(r - l == 0){
            if (r - l == t) {
                res += 1;
            } else if (r - l > t) {
//                res += 2;
                res += (r - l) / t + 1;
            }
        }
        res += 2;
        return res;
    }

    public static void main(String[] args) {
        int[] xa = new int[]{-1, 4, 5, 2};
        int t = 2;
        System.out.println(getHouses(t, xa));
    }
}
