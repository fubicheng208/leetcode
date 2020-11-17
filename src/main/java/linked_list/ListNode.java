package linked_list;

import java.io.Serializable;
import java.util.Collections;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class ListNode implements Serializable {
    int val;
    ListNode next;

    public ListNode(int x) {
        val = x;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode listNode = (ListNode) o;
        return val == listNode.val;
    }

}
