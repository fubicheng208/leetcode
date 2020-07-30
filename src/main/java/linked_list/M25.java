package linked_list;

public class M25 {
/*    输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
    示例1：
    输入：1->2->4, 1->3->4
    输出：1->1->2->3->4->4*/
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode i1 = l1, i2 = l2;
        ListNode head = new ListNode(-1), cur = head;
        while(i1 != null && i2 != null){
            if(i1.val < i2.val){
                cur.next = i1;
                i1 = i1.next;
            }else{
                cur.next = i2;
                i2 = i2.next;
            }
            cur = cur.next;
        }
        cur.next = (i1 != null) ? i1 : i2;
        return head.next;
    }
}
