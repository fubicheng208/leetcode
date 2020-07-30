package Boyer_Moore;

import java.util.Random;

public class Solution215 {
    //快速选择算法
    int[] nums;

    public void swap(int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    //将比nums[pivot_index]小的元素放到l的前几位置
    public int partition(int l, int r, int pivot_index) {
        int pivot = nums[pivot_index];
        swap(pivot_index, r);
        int store_index = l;//存到哪一个了

        for (int i = l; i < r; i++) {
            if (nums[i] < pivot) {
                swap(store_index, i);
                store_index++;
            }
        }
        //将Pivot换到最后位置，Pivot左边的都比它小
        swap(store_index, r);
        return store_index;
    }

    public int quickselect(int l, int r, int k_smallest) {
        if (l == r)
            return this.nums[l];
        Random ramdom = new Random();
        int pivot_index = l + ramdom.nextInt(r - l);//在l->r中随机选择一个枢纽
        pivot_index = partition(l, r, pivot_index);
        if (k_smallest == pivot_index)
            return nums[k_smallest];
        else if (k_smallest < pivot_index)
            return quickselect(l, pivot_index - 1, k_smallest);
        else
            return quickselect(pivot_index + 1, r, k_smallest);
    }

    public int findKthLargest(int[] nums, int k) {
        this.nums = nums;
        int size = nums.length;
        return quickselect(0, size - 1, size - k);
    }


}
