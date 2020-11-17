package linked_list;

public class M18 {
    public ListNode deleteNode(ListNode head, int val) {

/*        给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
        返回删除后的链表的头节点。*/

        ListNode pre = null, cur = head;
        while(cur != null){
            if(cur.val == val){
                //如果第一个节点就要删，那么要特殊处理
                if(pre == null){
                    head = cur.next;
                }else{
                    pre.next = cur.next;
                }
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        return head;
    }
}
