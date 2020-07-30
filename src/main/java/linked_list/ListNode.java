package linked_list;

import java.io.Serializable;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

public class ListNode implements Serializable {
    int val;
    ListNode next;
    ConcurrentHashMap map;

    ListNode(int x) {
        val = x;
    }
}
