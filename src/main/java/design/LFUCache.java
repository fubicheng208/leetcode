package design;

import javafx.scene.layout.Priority;

import java.util.*;

//Solution460 写错了，题目要求是最不经常使用算法，对于相同的使用最近最不经常使用；这里写的是最近最不经常使用；
public class LFUCache {
    int capacity;
    int nowAt;//当前轮次
    PriorityQueue<Node> heap;

    public LFUCache(int capacity) {
        //小顶堆
        this.capacity = capacity;
        nowAt = 0;
        if (capacity != 0) {
            heap = new MyPriorityQueue<>(capacity, new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    //若出现频次相同，则出现轮次小的排前面
                    return o1.times != o2.times ? o1.times - o2.times : o1.round - o2.round;
                }
            });
        }
    }

    public int get(int key) {
        if (capacity == 0) return -1;
        nowAt++;
        for (Node node : heap) {
            if (node.index == key) {
                node.times++;
                node.round = nowAt;
                //由于shiftUp为私有，故采用这种不优雅的方式，来做元素访问后的堆即时更改
                Node tmp = heap.poll();
                heap.add(tmp);
                return node.value;
            }
        }
        return -1;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;
        nowAt++;
        //查看堆中是否已经有这个key的Node
        int times = -1;
        Node tmp = null;
        for (Node node : heap) {
            if (node.index == key) {
                tmp = node;
                times = node.times + 1;
            }
        }
        if (tmp != null)
            heap.remove(tmp);
        Node node;
//        如果是新的Node
        if (times == -1)
            node = new Node(key, value, 0, nowAt);
        else
            node = new Node(key, value, times, nowAt);
        heap.add(node);
//        map.put(key,value);
    }

    class MyPriorityQueue<E> extends PriorityQueue<E> {
        MyPriorityQueue(int initialCapacity,
                        Comparator<? super E> comparator) {
            super(initialCapacity, comparator);
        }

        @Override
        public boolean offer(E e) {
            //如果已经达到数量上限，则删除堆顶元素
            if (size() == capacity)
                super.poll();
            return super.offer(e);
        }
    }

    class Node {
        int index;
        int value;
        int times;
        int round;//记录第几轮次，任何操作都新增一个轮次

        public Node(int index, int value, int times, int round) {
            this.index = index;
            this.value = value;
            this.times = times;
            this.round = round;
        }
    }
}
