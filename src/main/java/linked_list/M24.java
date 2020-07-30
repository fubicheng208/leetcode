package linked_list;

public class M24 {
    //1 2 3 4 5 N
    //5 4 3 2 1 N
    public ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head, next = null;
        while(cur != null){
            //记录下一个，以免丢失后续节点
            next = cur.next;
            //真正的倒转
            cur.next = pre;
            //当前这个节点对于下一个节点来说便是前一个节点
            pre = cur;
            //下一个节点对保存的另一段链表的头结点next做操作
            cur = next;
        }
        return pre;
    }
}
