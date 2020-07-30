package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solutio199 {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<Node> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        queue.add(new Node(root, 0));
        int depth = -1;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.depth != depth) {
                res.add(node.node.val);
                depth = node.depth;
            }
            if (node.node.right != null)
                queue.add(new Node(node.node.right, node.depth + 1));
            if (node.node.left != null)
                queue.add(new Node(node.node.left, node.depth + 1));
        }
        return res;
    }

    class Node {
        TreeNode node;
        int depth;

        public Node(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
}
