package linked_list;

/**
 * @author fubic
 * @date 2021-02-05
 */
public class Jindian02_03 {
/*    实现一种算法，删除单向链表中间的某个节点（即不是第一个或最后一个节点），假定你只能访问该节点。
    示例：
    输入：单向链表a->b->c->d->e->f中的节点c
    结果：不返回任何数据，但该链表变为a->b->d->e->f*/

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
