package tree;

public class M55_2 {
//    输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        return Math.abs(depth(root.left) - depth(root.right)) < 2 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int depth(TreeNode node){
        if(node == null)
            return 0;
        return Math.max(depth((node.left)), depth(node.right) ) + 1;
    }

}
