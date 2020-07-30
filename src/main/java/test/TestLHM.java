package test;

import java.util.LinkedHashMap;
import java.util.Map;

public class TestLHM {
    static class myLinkedHashMap<K, V> extends LinkedHashMap<K, V> {
        private final int size;

        myLinkedHashMap(int size) {
            super(size, 1, true);
            this.size = size;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry eldest) {
            return size() > size;
        }


    }

    public static void main(String[] args) {
        myLinkedHashMap<Integer, Integer> m = new myLinkedHashMap<>(3);
        m.put(1, 1);
        m.put(2, 2);

        System.out.println(m);

//        for(Map.Entry<Integer, Integer> entry : m.entrySet()){
//            System.out.println(entry.getValue());
//        }

        System.out.println(m.toString());
    }
}
