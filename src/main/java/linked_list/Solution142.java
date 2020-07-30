package linked_list;

/*给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。

        为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。*/

/*F + a = (F+a+b+a)/2 => F = b 注意：slow和quick需要同一起点出发*/

import java.util.concurrent.atomic.AtomicInteger;

public class Solution142 {
    public ListNode detectCycle(ListNode head) {
        StringBuffer s;
        StringBuilder s1;
        String s2;
        ListNode quick = meetNodeAt(head);
        //无环
        if (quick == null)
            return null;
        ListNode slow = head;
        while (slow != quick) {
            slow = slow.next;
            quick = quick.next;
        }
        return quick;
    }

    public ListNode meetNodeAt(ListNode head) {
        if (head == null || head.next == null)
            return null;
        ListNode quick = head;
        ListNode slow = head;
        //quick.next.next可以为空，下次循环会跳出
        while (quick != null && quick.next != null) {
            quick = quick.next.next;
            slow = slow.next;
            if (quick == slow)
                return quick;
        }
        return null;
    }

    AtomicInteger a;
}
