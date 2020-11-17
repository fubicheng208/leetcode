package linked_list;

import java.util.Stack;

public class M06 {

/*    输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
    示例 1：
    输入：head = [1,3,2]
    输出：[2,3,1]*/

    public int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode node = head;
        while(node != null){
            stack.push(node);
            node = node.next;
        }
        int[] res = new int[stack.size()];
        int i = 0;
        while(!stack.isEmpty()){
            ListNode tmp = stack.pop();
            res[i++] = tmp.val;
        }
        return res;
    }
}
