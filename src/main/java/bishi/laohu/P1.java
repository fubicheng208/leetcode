package bishi.laohu;

public class P1 {
    /**
     * @param array int整型一维数组
     * @return int整型一维数组
     */
    public static int[] reOrderArray(int[] array) {
        if (array == null || array.length == 0)
            return array;
        int e = 0;
        int o = array.length - 1;
        while (e < o) {
            while (e < o && (array[e] & 1) == 1) {
                e++;
            }
            while (e < o && (array[o] & 1) == 0) {
                o--;
            }
            int tmp = array[e];
            array[e] = array[o];
            array[o] = tmp;
/*            if(e<array.length && o>=0){
                int tmp = array[e];
                array[e] = array[o];
                array[o] = tmp;
            }*/
        }
        return array;
    }

    public static void main(String[] args) {
        int a[] = new int[]{2, 2, 1, 1};
        a = reOrderArray(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

    }
}
