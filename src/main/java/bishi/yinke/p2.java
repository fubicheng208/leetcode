package bishi.yinke;



public class p2 {
    public ListNode mergeKLists (ListNode[] lists) {
        // write code here
        if(lists == null || lists.length == 0)
            return null;
        return merge(lists, 0, lists.length - 1);

/*        ListNode ans = null;
        for (int i = 0; i < lists.length; i++) {
            ans = mergeTwoLists(ans, lists[i]);
        }
        return ans;*/
    }

    public ListNode merge(ListNode[] lists, int l, int r){
        if(l == r){
            return lists[l];
        }
        if(l > r){
            return null;
        }
        int mid = (l + r) >> 1;
        return mergeTwoLists(merge(lists, l, mid), merge(lists, mid + 1, r));
    }

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
