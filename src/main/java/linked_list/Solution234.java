package linked_list;

import java.rmi.UnexpectedException;
import java.util.List;
import java.util.Stack;

/**
 * @author fubic
 * @date 2021-11-29
 */
public class Solution234 {

//    给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
//    输入：head = [1,2,2,1]
//    输出：true

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }
        if(head.next == null){
            return true;
        }

        ListNode halfNode = getHalfNode(head);
        ListNode secondHead = reverseListNode(halfNode.next);
        ListNode p = head;
        ListNode q = secondHead;
        boolean result = true;
        while(result && q != null){
            if(p.val != q.val){
                result = false;
            }
            p = p.next;
            q = q.next;
        }
        reverseListNode(secondHead);
        return result;
    }

    public ListNode reverseListNode(ListNode node){
        ListNode pre = null;
        ListNode cur = node;
        while(cur != null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    public ListNode getHalfNode(ListNode node){
        ListNode slow = node;
        ListNode fast = node;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
