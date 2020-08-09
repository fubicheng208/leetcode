package sort;

import java.util.Scanner;

public class InsertSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int[] b = insertSort(a);
        for (int t : b) {
            System.out.println(t);
        }
    }

    public static int[] insertSort(int[] a) {
        int tmp;
        //从前到后，从第二个数开始，寻找自己的位置插入
        for (int i = 1; i < a.length; i++) {
            //保存最后面的值
            tmp = a[i];
            int j = i - 1;
            //当要插入的值tmp < 前一个数时，该数便后移一位
            while (j >= 0 && tmp < a[j]) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = tmp;
        }
        return a;
    }
}
