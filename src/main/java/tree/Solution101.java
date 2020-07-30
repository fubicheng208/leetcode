package tree;

import java.util.LinkedList;
import java.util.Queue;

public class Solution101 {
    //写错了，这是每颗子树都相等的判断
    /*public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        boolean left = isSymmetric(root.left);
        boolean right = isSymmetric(root.right);
        if (left && right) {
            if (root.left == null && root.right == null)
                return true;
            else if (root.left == null || root.right == null)
                return false;
            else {
                return root.left.val == root.right.val;
            }
        }
        return false;
    }*/

    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return check(root.left, root.right);
    }

    //递归
    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }

    //非递归
    public boolean check2(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(p);
        queue.add(q);
        while (!queue.isEmpty()) {
            //连续出的两个即为镜像节点
            p = queue.poll();
            q = queue.poll();
            //都为空，则为true，继续下一次
            if (p == null && q == null)
                continue;
            if ((p == null || q == null) || p.val != q.val)
                return false;
            //到这里则p,q都不为空
            queue.add(p.left);
            queue.add(q.right);
            queue.add(p.right);
            queue.add(q.left);
        }
        return true;
    }
}
