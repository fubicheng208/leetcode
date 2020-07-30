package array;

import java.util.ArrayList;
import java.util.List;

public class M17 {
    public int[] printNumbers(int n) {
        int biggest = (int)Math.pow(10, n);
        int[] res = new int[biggest - 1];
        for(int i = 1; i < biggest; i++)
            res[i-1] = i;
        return res;
    }
}
