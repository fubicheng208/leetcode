package bishi.sogou;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class Main {
    public static void main(String[] args) {
/*        P3 p3 = new P3();
        System.out.println(p3.getPasswordCount("12345"));*/
//        System.out.println(p3.getPasswordCount("09"));
//        System.out.println(p3.getPasswordCount("3"));

        P1 p1 = new P1();
        System.out.println(p1.numberofprize(4, 4, 2));
        System.out.println(p1.numberofprize(9, 3, 3));

    }
}
