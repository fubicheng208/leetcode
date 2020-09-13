package linked_list;

public class M18 {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode pre = null, node = head;
        while(node != null){
            if(node.val == val){
                if(pre == null){
                    head = node.next;
                }else{
                    pre.next = node.next;
                }
                break;
            }
            pre = node;
            node = node.next;
        }
        return head;
    }
}
