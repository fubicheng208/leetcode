package test;

import java.util.List;

public class Fanxing {
    public static void setUser(List<? extends User> list) {
        System.out.println(list.toString());
    }
}
