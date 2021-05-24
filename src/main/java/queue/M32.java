package queue;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class M32 {
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> tmp = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode p = queue.poll();
            if (p != null) {
                tmp.add(p.val);
                queue.add(p.left);
                queue.add(p.right);
            }
        }
        int[] res = new int[tmp.size()];
        for (int i = 0; i < tmp.size(); i++) {
            res[i] = tmp.get(i);
        }
        return res;
    }
}
