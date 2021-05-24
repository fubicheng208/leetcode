package linked_list;

/**
 * @author fubic
 * @date 2021-05-21
 */
public class Solution25 {

//    pre记录翻转好链表的尾部；
//    nextHead记录下一次翻转链表的头部；
//    subHead记录当前翻转链表的头部；
//    subEnd记录当前翻转链表的尾部；
//    当前翻转链表翻转完成后，只需将原尾部subEnd接到pre后，再修改pre。

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null){
            return null;
        }
        ListNode hair = new ListNode(-1);
        hair.next = head;
        ListNode subHead = hair; //子链表原始开头（新尾）
        ListNode subEnd = head; //子链表原始尾（新开头）
        ListNode nextHead = head;
        while(nextHead != null){
            ListNode pre = subHead; //记录上一个翻转子链表的尾部位置，之后在其后接上新翻转子链表的原始尾
            subHead = nextHead; //上一次翻转时记录的下一次的开始头部
            //找到k长链表尾
            for (int i = 0; i < k; i++) {
                if(nextHead == null){ //不满足k个，直接接
                    pre.next = subHead;
                    return hair.next;
                }
                nextHead = nextHead.next;
            }
            subEnd = reverse(subHead, k);
            pre.next = subEnd; //接上新翻转子链表的原始尾
        }
        return hair.next;

    }

    //翻转head节点后k-1个节点
    public ListNode reverse(ListNode head, int k){
        ListNode pre = null;
        ListNode cur = head;
        int i = 0;
        while(cur != null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
            if(++i == k){
                return pre;
            }
        }
        return pre;
    }
}
