package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class M40 {

    //    输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
    public int[] getLeastNumbers(int[] arr, int k) {
        //大顶堆
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int num : arr) {
            pq.add(num);
            if (pq.size() > k)
                pq.poll();
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }
        return res;
    }

}
