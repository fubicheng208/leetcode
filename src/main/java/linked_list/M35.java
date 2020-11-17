package linked_list;

import java.util.HashMap;
import java.util.Map;

public class M35 {
    /*    请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
        链接：https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof*/
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        //创建新节点，并保存和原节点的对应关系
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        //根据原节点创建新节点的关系
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);

    }

    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
