package linked_list;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fubic
 * @date 2021-05-22
 */
public class LRUCache {


/*    运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制 。
    实现 LRUCache 类：

    LRUCache(int capacity) 以正整数作为容量capacity 初始化 LRU 缓存
    int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
    void put(int key, int value)如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。

    进阶：你是否可以在O(1) 时间复杂度内完成这两种操作？

    示例：

    输入
    ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
        [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
    输出
    [null, null, null, 1, null, -1, null, -1, 3, 4]*/

    class DLinkedNode{
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode(){}
        public DLinkedNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    int capacity;
    Map<Integer, DLinkedNode> cache = new HashMap<>();
    DLinkedNode head;
    DLinkedNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if(node == null){
            return -1;
        }
        moveToFirst(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        //存在，移动到链表头
        if(node != null){
            //值不相等要修改为新值
            if(node.value != value){
                node.value = value;
            }
            moveToFirst(node);
        }else{
            //不存在，新建节点，连接到链表头
            DLinkedNode newNode = new DLinkedNode(key, value);
            //超出容量，删除最后一个节点，再连接到链表头
            if(cache.size() >= capacity){
                DLinkedNode readyToRemove = removeLast();
                cache.remove(readyToRemove.key);
            }
            cache.put(key, newNode);
            addToFirst(newNode);
        }
    }

    public void moveToFirst(DLinkedNode node){
        //从原位置删除
        node.prev.next = node.next;
        node.next.prev = node.prev;
        //接到链表头
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }

//    public void addToLast(DLinkedNode node){
//        node.next = tail;
//        node.prev = tail.prev;
//        tail.prev.next = node;
//        tail.prev = node;
//    }

    public void addToFirst(DLinkedNode node){
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    public DLinkedNode removeLast(){
        DLinkedNode node = tail.prev;
        node.prev.next = tail;
        tail.prev = node.prev;
        return node;
    }
}
