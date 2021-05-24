package linked_list;

/**
 * @author fubic
 * @date 2021-05-14
 */
public class M2 {

/*    给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。

    请你将两个数相加，并以相同形式返回一个表示和的链表。

    你可以假设除了数字 0 之外，这两个数都不会以 0 开头。*/


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode p = head;
        int carry = 0;
        while(l1 != null || l2 != null){
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            int val = sum % 10;
            carry = sum / 10;
            p.next = new ListNode(val);
            p = p.next;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        if(carry != 0){
            p.next = new ListNode(carry);
        }
        return head.next;
    }
}
