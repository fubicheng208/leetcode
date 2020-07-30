package test;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

public class TestFanxing {
    public static void main(String[] args) {
        List<User> ls = new ArrayList<>();
        ls.add(new User("up1"));
        ls.add(new User("up2"));
        ListFanxing lf1 = new ListFanxing();
        lf1.setList(ls);
        lf1.setName("lf1");

        List<User> ls2 = new ArrayList<>();
        ls2.add(new User2("up", "us1"));
        ls2.add(new User2("up", "us2"));
        ListFanxing lf2 = new ListFanxing();
        lf2.setList(ls2);
        lf2.setName("lf2");


        String js1 = JSON.toJSONString(lf1);
        System.out.println(js1);

        String js2 = JSON.toJSONString(lf2);
        System.out.println(js2);


        ListFanxing o1 = JSON.parseObject(js1, ListFanxing.class);
        ListFanxing o2 = JSON.parseObject(js2, ListFanxing.class);
        System.out.println(o1.getList());
        System.out.println(o2.getList());


//        List<? extends User> ls = new ArrayList<>();
//        ls.add(new User("up"));
//        ls.add(new User2("up", "us"));

    }
}
