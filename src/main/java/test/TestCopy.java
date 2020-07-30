package test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class TestCopy {
    public static void main(String[] args) {
        /*总结：
        clone可copy多维数组
        clone多维数组，是拷贝的每个数组的地址；
        clone一维数组，拷贝的是每个数组元素；

        Array.copy只能针对一维数组，拷贝的是每个元素；且底层由System.arraycopy实现

        System.arraycopy只能针对一维数组，拷贝的是每个元素；*/

        System.out.println("\n测试一维基本类型数组\n");

        //测试一维数组
        int[] a = {1, 2, 3};
        int[] b1 = a;
        int[] b2 = Arrays.copyOf(a, a.length);
        int[] b3 = new int[a.length];
        int[] b4 = a.clone();
        System.arraycopy(a, 0, b3, 0, a.length);
        a[0] = 100;

        printEach(b1, "直接引用方式");
        printEach(b2, "Arrays.copy方式");
        printEach(b3, "System.arraycopy()方式");
        printEach(b4, "clone方式");

        System.out.println("\n测试二维基本类型数组\n");
        //测试二维数组
        int[][] c = {{1, 2, 3}, {4, 5, 6}};
        int[][] d1 = c;
        int[][] d2 = new int[2][3];
        for (int i = 0; i < c.length; i++) {
            d2[i] = Arrays.copyOf(c[i], c[i].length);
        }
        int[][] d3 = new int[2][3];
        d3 = c.clone();
        c[0][0] = 100;
        printEach2(d1, "直接引用方式");
        printEach2(d2, "Arrays.copy方式");
        printEach2(d3, "clone方式");

        System.out.println("\n测试一维对象数组\n");

        String[] e = {"1", "2", "3"};
        String[] f1 = Arrays.copyOf(e, e.length);
        String[] f2 = e.clone();
        e[0] = "100";
        printEachObject(f1, "Arrays.copy方式");
        printEachObject(f2, "clone方式");

        System.out.println("\n测试二维对象数组\n");

        String[][] g = {{"1", "2", "3"}, {"1", "2", "3"}};
        String[][] h1 = new String[2][3];
        for (int i = 0; i < c.length; i++) {
            h1[i] = Arrays.copyOf(g[i], g[i].length);
        }
        String[][] h2 = g.clone();
//        for(int i=0; i<c.length; i++){
//            h2[i] = Arrays.copyOf(g[i], g[i].length);
//        }
        g[0][0] = "100";
        printEachObject2(h1, "Arrays.copy方式");
        printEachObject2(h2, "clone方式");

    }

    public static void printEach(int[] a, String tag) {
        System.out.println(tag);
        for (int i : a) {
            System.out.printf("%d ", i);
        }
        System.out.println();
    }

    public static void printEach2(int[][] a, String tag) {
        System.out.println(tag);
        for (int[] t : a) {
            for (int i : t) {
                System.out.printf("%d ", i);
            }
            System.out.println();
        }
    }

    public static <T> void printEachObject(T[] a, String tag) {
        System.out.println(tag);
        for (T i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static <T> void printEachObject2(T[][] a, String tag) {
        System.out.println(tag);
        for (T[] t : a) {
            for (T i : t) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

}
