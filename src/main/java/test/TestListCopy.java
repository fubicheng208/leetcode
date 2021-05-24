package test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestListCopy {
    public static void main(String[] args) {
        List<Integer> ls = new ArrayList<>();
        ls.remove(new Integer(1));
        ls.add(1);
        ls.add(2);
        int[] a = new int[]{1, 2};
        List<Integer> ls2 = new ArrayList(ls);
        ls.set(0, 999);
        System.out.println(ls.toString());
        System.out.println(ls2.toString());

        LinkedList<Integer> ll = new LinkedList<>();
    }
}
