package sort;

public class MergeSort {

    public static void mergeSort(int[] nums, int l ,int r){
        //即终止条件为l >= r
        if(l < r){
            int mid = (l + r)/2;
            mergeSort(nums, l, mid);
            mergeSort(nums, mid + 1, r);
            merge(nums, l, mid, r);
        }
    }

    public static void merge(int[] nums, int l, int mid, int r){
        //新建一个数组
        int[] arr = new int[r - l + 1];
        int p1 = l;
        int p2 = mid + 1;
        int p = 0;

        while(p1 <= mid && p2 <= r){
            arr[p++] = nums[p1] < nums[p2] ? nums[p1++] : nums[p2++];
        }
        //左边还未全部移入新的数组，右边已全部移入
        if(p1 <= mid){
            System.arraycopy(nums, p1, arr, p, mid - p1 + 1);
        }else{
            System.arraycopy(nums, p2, arr, p, r - p2 + 1);
        }
        System.arraycopy(arr, 0, nums, l, arr.length);
    }

}
