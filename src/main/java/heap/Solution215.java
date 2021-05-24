package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution215 {
    public static int findKthLargest(int[] nums, int k) {
        //小顶堆（默认）
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        for (int n : nums) {
            heap.add(n);
            if (heap.size() > k){
                heap.poll();
            }
        }
        return heap.poll();
    }

    public int findKthSmallest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for(int n : nums){
            heap.add(n);
            if(heap.size() > k){
                heap.poll();
            }
        }
        return heap.poll();
    }
}
