package bishi.yinke;

import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;

public class ListNode implements Serializable {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }
}
