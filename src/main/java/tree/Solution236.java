package tree;

public class Solution236 {
    TreeNode res = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        postOrder(root, p, q);
        return res;
    }

    public boolean postOrder(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return false;
        boolean l = postOrder(root.left, p, q);
        boolean r = postOrder(root.right, p, q);
        if ((l && r) || ((l || r) && (root == p || root == q))) {
            res = root;
            return false;
        }
        if (root == p || root == q)
            return true;
        return l || r;
    }


}
