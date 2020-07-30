package design;

import java.util.LinkedHashMap;
import java.util.Map;

//Solution460 写错了，题目要求是最不经常使用算法，对于相同的使用最近最不经常使用；这里写的是最近最不经常使用；
public class LRUCache {
    MyLinkedHashMap<Integer, Integer> map;

    public LRUCache(int capacity) {
        map = new MyLinkedHashMap<>(capacity);
    }

    public int get(int key) {
        return map.get(key) == null ? -1 : map.get(key);
    }

    public void put(int key, int value) {
        map.put(key, value);
    }

    class MyLinkedHashMap<K, V> extends LinkedHashMap<K, V> {
        private final int size;

        MyLinkedHashMap(int size) {
            super(size, 1, true);//设置accessOrder是为了插入时改变链表顺序，默认为false;
            this.size = size;
        }

        //重写此方法是为了在长度>capacity时删除最老的元素
        @Override
        protected boolean removeEldestEntry(Map.Entry eldest) {
            return size() > size;
        }

    }
}
