package tree;

import java.util.LinkedList;
import java.util.Queue;

public class Solution116 {

    public Node connect(Node root) {
        if (root == null)
            return null;
        Node leftmost = root;
        while (leftmost.left != null) {
            Node head = leftmost;
            while (head != null) {
                head.left.next = head.right;//连接1：连接下一层同一子树左右节点
                if (head.next != null)
                    head.right.next = head.next.left;//连接2: 连接非同一子树右左节点
                head = head.next;
            }
            leftmost = leftmost.left;
        }
        return root;
    }

    //    public Node connect(Node root) {
//        if(root == null)
//            return null;
//        Queue<Node> queue = new LinkedList<>();
//        queue.add(root);
//        while(!queue.isEmpty()){
//            int size = queue.size();
//            for(int i=0; i<size; i++){
//                Node node = queue.poll();
//                if(i < size-1)
//                    node.next = queue.peek();
//                if(i == size-1)
//                    node.next = null;
//                if(node.left != null)
//                    queue.add(node.left);
//                if(node.right != null)
//                    queue.add(node.right);
//            }
//        }
//        return root;
//    }
//
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    ;
}
