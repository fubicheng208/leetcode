package bishi.tx;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P1_o {

    static class Node{
        public int value;
        public Node next;
        public Node(int data){
            this.value = data;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Node head1 = new Node(-1);
        Node h1 = head1;
        for (int i = 0; i < n; i++) {
            Node node = new Node(scanner.nextInt());
            h1.next = node;
            h1 = node;
        }
        h1.next = null;

        int m= scanner.nextInt();
        Node head2 = new Node(-1);
        Node h2 = head2;
        for (int i = 0; i < m; i++) {
            Node node = new Node(scanner.nextInt());
            h2.next = node;
            h2 = node;
        }
        h2.next = null;

        int cnt = 0;
        Node u1 = head1.next;
        Node u2 = head2.next;
        String res = "";
        while(u1 != null && u2 != null){
            if(u1.value < u2.value){
                u1 = u1.next;
            }else if(u1.value > u2.value){
                u1 = u1.next;
            }else{
                res += u1.value + " ";
                u1 = u1.next;
                u2 = u2.next;
            }
        }
        String tm = res.substring(0, res.length() - 1);
        System.out.println(tm);
    }
}
