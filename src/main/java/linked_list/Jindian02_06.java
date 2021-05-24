package linked_list;

/**
 * @author fubic
 * @date 2021-02-09
 */
public class Jindian02_06 {
/*    编写一个函数，检查输入的链表是否是回文的。

    示例 1：
    输入： 1->2
    输出： false*/
    //利用递归实现从后往前，同时使用类变量保存从前到后的指针
    ListNode start;
    public boolean isPalindrome(ListNode head) {
        start = head;
        return recursivelyCheck(head);
    }

    //判断当前前后指针指向的值是否一致
    public boolean recursivelyCheck(ListNode end){
        if(end != null){
            //有一节点双指针值不一致，则要逐级返回false
            if(!recursivelyCheck(end.next)){
                return false;
            }
            //判断当前两个指针的值是否相等，若不等则逐级返回false
            if(start.val != end.val){
                return false;
            }
            //如果相等，则返回上一个栈帧，判断下一对节点值是否相同
            start = start.next;
        }
        return true;
    }
}
