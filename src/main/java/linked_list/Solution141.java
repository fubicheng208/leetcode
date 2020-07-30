package linked_list;

/*给定一个链表，判断链表中是否有环。

        为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。*/

public class Solution141 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;

        ListNode quick = head.next;
        ListNode slow = head;
        while (quick != slow) {
            if (quick.next == null || quick.next.next == null)
                return false;
            quick = quick.next.next;
            slow = slow.next;
        }
        return true;
    }
}
