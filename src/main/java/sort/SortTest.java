package sort;

public class SortTest {
    public static void main(String[] args) {
        int[] a = new int[]{0,3,4,2,1,5};
//        a = BubbleSort.bubbleSort(a);
//        QuickSort.quickSort2(a, 0, 4);
//        SelectSort.selectSort(a);
//        MergeSort.mergeSort(a, 0, 4);
        HeapSort.heapSort(a, 5);
        for(int num : a){
            System.out.println(num);
        }
    }
}
