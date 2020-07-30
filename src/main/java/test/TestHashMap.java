package test;

import sun.rmi.server.UnicastServerRef;

import java.util.HashMap;
import java.util.Map;

public class TestHashMap {
    public static void main(String[] args) {
//        HashMap<Integer, Integer>map = new HashMap<>();
//        map.put(1,1);
//        map.put(2,2);
//        HashMap<Integer, Integer> c_map  = (HashMap<Integer, Integer>) map.clone();
//        System.out.println(map.toString());
//        System.out.println(c_map.toString());
////        map.put(1,3);
//        c_map.put(1,3);
//        System.out.println(map.toString());
//        System.out.println(c_map.toString());

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        HashMap<Integer, Integer> c_map = (HashMap<Integer, Integer>) map.clone();
        System.out.println(map.toString());
        System.out.println(c_map.toString());
//        map.put(1,3);
//        c_map.put(1,3);
        map.remove(2);
        System.out.println(map.toString());
        System.out.println(c_map.toString());

//        HashMap<Integer, User>map = new HashMap<>();
//        User u1 = new User("1");
//        User u2 = new User("2");
//        map.put(1,u1);
//        map.put(2,u2);
//        HashMap<Integer, User> c_map  = (HashMap<Integer, User>) map.clone();
////        User t = map.get(1);
////        t.setName("change");
//        User t = new User("change");
//        map.put(3,t);
//        System.out.println(map.toString());
//        System.out.println(c_map.toString());
//        map.put(1,3);
//        c_map.put(1,3);
//        System.out.println(map.toString());
//        System.out.println(c_map.toString());
    }


}
