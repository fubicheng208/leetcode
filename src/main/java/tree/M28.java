package tree;

import javax.swing.*;

public class M28 {
//    请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        return check(root.left, root.right);
    }

    public boolean check(TreeNode p, TreeNode q){
        if(p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }
}
