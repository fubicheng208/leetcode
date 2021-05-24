package linked_list;

/**
 * @author fubic
 * @date 2021-02-08
 */
public class Jindian02_05 {
/*    给定两个用链表表示的整数，每个节点包含一个数位。
    这些数位是反向存放的，也就是个位排在链表首部。
    编写函数对这两个整数求和，并用链表形式返回结果。


    示例：
    输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
    输出：2 -> 1 -> 9，即912*/

    //注意 5 + 5 找各种情况，进位不为0，需要继续循环
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null){
            return null;
        }
        ListNode head = new ListNode(-1);
        ListNode pos = head;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0){
            int num = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
            carry = num / 10;
            num = num % 10;
            ListNode tmp = new ListNode(num);
            pos.next = tmp;
            pos = tmp;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        return head.next;
    }
}
