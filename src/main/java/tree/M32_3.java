package tree;

import java.util.*;

public class M32_3 {
    //    请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean odd = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> q = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();
                if (odd) {
                    q.addLast(tmp.val);
                } else {
                    q.addFirst(tmp.val);
                }
                queue.add(tmp.left);
                queue.add(tmp.right);
            }
            res.add(q);
            odd = !odd;
        }
        return res;
    }
}
