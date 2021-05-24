package linked_list;

import java.util.HashSet;

/**
 * @author fubic
 * @date 2021-02-04
 */
public class Jindian02_01 {
/*    编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。

    示例1:
    输入：[1, 2, 3, 3, 2, 1]
    输出：[1, 2, 3]*/
    HashSet<Integer> hs = new HashSet<>();
    public ListNode removeDuplicateNodes(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode n = head;
        ListNode pre = n;
        hs.add(n.val);
        n = n.next;
        while(n != null){
            if(hs.contains(n.val)){
                pre.next = n.next;
            }else{
                hs.add(n.val);
                pre = n;
            }
            n = n.next;
        }
        return head;
    }
}
