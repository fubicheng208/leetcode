package test;

import linked_list.ListNode;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class TestHashSet {
    public static void main(String[] args) {
        HashSet<ListNode> hs = new HashSet<>();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = n1;
        System.out.println(n1.hashCode());
        System.out.println(n2.hashCode());
        System.out.println(n3.hashCode());
        System.out.println(hs.add(n1));
        System.out.println(hs.add(n2));
        System.out.println(hs.size());
        Iterator<ListNode> iterator = hs.iterator();
        while(iterator.hasNext()){
            ListNode n = (ListNode)iterator.next();
            System.out.println(n.toString());
        }
    }
}
