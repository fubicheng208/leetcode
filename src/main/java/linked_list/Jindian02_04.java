package linked_list;

/**
 * @author fubic
 * @date 2021-02-07
 */
public class Jindian02_04 {

/*    编写程序以 x 为基准分割链表，使得所有小于 x 的节点排在大于或等于 x 的节点之前。如果链表中包含 x，x 只需出现在小于 x 的元素之后(如下所示)。分割元素 x 只需处于“右半部分”即可，其不需要被置于左右两部分之间。

    示例:

    输入: head = 3->5->8->5->10->2->1, x = 5
    输出: 3->1->2->10->5->5->8*/

    //在原链表上交换，未提交成功，太复杂
    // public ListNode partition(ListNode head, int x) {
    //     if(head == null){
    //         return head;
    //     }
    //     //创建一个空的头结点，防止第一个Node就比x大的特殊情况
    //     ListNode fakeHead = new ListNode(-1);
    //     fakeHead.next = head;
    //     ListNode big = head;
    //     ListNode small = head;
    //     ListNode tmp;
    //     ListNode preB = fakeHead;
    //     ListNode preS = fakeHead;
    //     while(big != null || small != null){
    //         //找到第一个比>=x的节点
    //         int indexB = 0;
    //         while(big != null && big.val < x ){
    //             preB = big;
    //             big = big.next;
    //             indexB++;
    //         }
    //         //找到第一个<x的节点(必须要在>=x节点的右边，因为如在在左边，就已经满足要求，不需要交换)
    //         int indexS = 0;
    //         while(small != null && (small.val >= x || indexB >= indexS)){
    //             preS = small;
    //             small = small.next;
    //             indexS++;
    //         }
    //         //交换big和small两个节点
    //         if(big != null && small != null){
    //             preS.next = big;
    //             preB.next = small;
    //             tmp = small.next;
    //             small.next = big.next;
    //             big.next = tmp;

    //         }
    //     }
    //     return fakeHead.next;
    // }

    //两链表拼接
    public ListNode partition(ListNode head, int x) {
        ListNode smallHead = new ListNode(-1);
        ListNode bigHead = new ListNode(-1);
        ListNode small = smallHead;
        ListNode big = bigHead;

        ListNode tmp = head;
        while(tmp != null){
            if(tmp.val < x){
                small.next = tmp;
                small = tmp;
            }else{
                big.next = tmp;
                big = tmp;
            }
            tmp = tmp.next;
        }
        small.next = bigHead.next;
        big.next = null;
        return smallHead.next;
    }
}
