package array;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class M56 {
    //    给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B 中的元素 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
    public int[] constructArr(int[] a) {
//        int productWithZero = Arrays.stream(a).reduce(1, (t1, t2) -> t1 * t2);
//        int productWithoutZero = Arrays.stream(a).filter(i -> i!=0).reduce(1, (t1, t2) -> t1 * t2);
//        int[] res = Arrays.stream(a).map(n -> product / n).toArray();
        if (a == null || a.length == 0)
            return a;
        int[] productLeft = new int[a.length];
        int[] productRight = new int[a.length];
        int[] res = new int[a.length];
        productLeft[0] = 1;
        productRight[a.length - 1] = 1;
        int product = 1;
        for (int i = 1; i < a.length; i++) {
            product *= a[i - 1];
            productLeft[i] = product;
        }
        product = 1;
        for (int j = a.length - 2; j >= 0; j--) {
            product *= a[j + 1];
            productRight[j] = product;
        }
        for (int i = 0; i < a.length; i++) {
            res[i] = productLeft[i] * productRight[i];
        }
        return res;
    }
}
