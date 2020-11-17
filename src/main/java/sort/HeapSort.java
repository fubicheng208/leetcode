package sort;

public class HeapSort {
    public static void heapSort(int[] R, int n) {
        //数组从1开始存储
        //从第一个非叶子节点开始，初始化大顶堆
        for (int i = n / 2; i >= 1; i--) {
            sift(R, i, n);
        }
        //每一轮将堆顶节点和最底最右子节点交换，并调整新的堆顶到其位置上
        for (int i = n; i >= 2; i--) {
            int tmp = R[i];
            R[i] = R[1];
            R[1] = tmp;
            sift(R, 1, i - 1);
        }
    }

    //将某个节点向下调整到合适的位置
    public static void sift(int[] R, int low, int high) {
        int i = low, j = 2 * i;//j指向其左孩子
        int tmp = R[i];
        while (j <= high) {
            //j指向左右中最大的孩子
            if (j != high && R[j] < R[j + 1]) {
                j++;
            }
            //如果孩子比他大，就将其和最大的孩子交换位置
            if (tmp < R[j]) {
                R[i] = R[j];
                i = j;
                j = 2 * i;
            } else {
                //如果左右孩子都比他小，则结束
                break;
            }
        }
        R[i] = tmp;
    }

    public static void heapSort2(int[] R, int n){
        for (int i = n/2; i >= 1 ; i--) {
            sift(R, i, n);
        }
        for (int i = n; i >= 2; i--) {
            int tmp = R[i];
            R[i] = R[1];
            R[1] = tmp;
            sift(R, 1, i - 1);
        }
    }

    //调整大顶堆堆顶到合适位置
    public static void sift2(int[] R, int low, int high){
        int i = low, j = 2 * i;
        int tmp = R[i];
        while(j <= high){
            if(j != high && R[j+1] > R[j]){
                j++;
            }
            if(tmp < R[j]){
                R[i] = R[j];
                i = j;
                j = 2 * i;
            }else{
                break;
            }
        }
        R[i] = tmp;
    }

}
