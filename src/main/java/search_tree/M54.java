package search_tree;

/*给定一棵二叉搜索树，请找出其中第k大的节点。
        示例 1:

        输入: root = [3,1,4,null,2], k = 1
        3
        / \
        1   4
        \
           2
        输出: 4*/


public class M54 {
    int ans = -1, now = 0, k;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        helper(root);
        return ans;
    }

    public void helper(TreeNode node){
        if(node == null)
            return;
        helper(node.right);
        now++;
        if(now == k)
            ans = node.val;
        helper(node.left);
    }

}
