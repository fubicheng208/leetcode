package dp.pack;

import com.sun.xml.internal.bind.v2.runtime.output.SAXOutput;

public class Test {
    public static void main(String[] args) {
/*        Lint440_full_value l = new Lint440_full_value();
        int[] A = new int[]{2,3,5,7};
        int[] V = new int[]{1,5,2,4};
        int m = 10;
        System.out.println(l.backPackIII(m, A, V));
//        System.out.println(l.backPackIIIV2(m, A, V));*/


        Lint562_full_cnt l3 = new Lint562_full_cnt();
/*        int[] A = new int[]{2,3,6,7};
        int target = 7;*/
        int[] A = new int[]{1, 2};
        int target = 4;
        System.out.println(l3.backPackIV(A, target));
        System.out.println(l3.backPackIVV2(A, target));

/*        Lint563_01_cnt l2 = new Lint563_01_cnt();
        int[] A = new int[]{1,2,3,3,7};
        int target = 7;
        System.out.println(l2.backPackVV2(A, target));*/
    }
}
