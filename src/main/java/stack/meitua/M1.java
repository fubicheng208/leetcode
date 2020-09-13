package stack.meitua;


import bishi.yinke.ListNode;

import java.util.Stack;

public class M1 {

    public ListNode addInList (ListNode head1, ListNode head2) {
        // write code here
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();
        ListNode res = new ListNode(-1);

        while(head1 != null){
            s1.add(head1);
            head1 = head1.next;
        }

        while(head2 != null){
            s2.add(head2);
            head2 = head2.next;
        }

        ListNode p1 = null, p2 = null;
        ListNode post = null;
        //进位
        int t = 0;
        while(s1.size() > 0 || s2.size() > 0){
            if(s1.size() > 0){
                p1 = s1.pop();
            }
            if(s2.size() > 0){
                p2 = s2.pop();
            }
            ListNode tmp;
            int score;
            if(p1 == null || p2 == null){
                score = p1 != null ? p1.val + t : p2.val + t;
            }else{
                score = p1.val + p2.val + t;
            }
            if(score >= 10){
                tmp = new ListNode(score % 10);
                t = 1;
            }else{
                tmp = new ListNode(score);
                t = 0;
            }
            //头插法
            res.next = tmp;
            tmp.next = post;
            post = tmp;
        }
        return res.next;
    }
}
