package sort;

public class SortTest {
    public static void main(String[] args) {
        int[] a = new int[]{0,3,4,2,5,1};
//        a = BubbleSort.bubbleSort(a);
//        QuickSort.quickSort2(a, 0, 5);
//        SelectSort.selectSort(a);
//        MergeSort.mergeSort(a, 0, 5);
        HeapSort.heapSort2(a, 5);
        for(int num : a){
            System.out.println(num);
        }
    }
}
