package tree;

/**
 * @author fubic
 * @date 2021-02-28
 */
public class Jindian0404 {
/*    实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。
    示例 1:
    给定二叉树 [3,9,20,null,null,15,7]
            3
            / \
            9  20
            /  \
            15   7
    返回 true 。*/

    //思路：通过计算高度的方法来检验平衡性
    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }

    public int height(TreeNode node){
        if(node == null){
            return 0;
        }
        int l = height(node.left);
        int r = height(node.right);

        if(l == -1 || r == -1 || Math.abs(l - r) > 1){
            return -1;
        }else{
            return Math.max(l, r) + 1;
        }
    }
}
