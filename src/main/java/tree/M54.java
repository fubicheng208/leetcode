package tree;

public class M54 {
    int now = 0, ans = -1;
    public int kthLargest(TreeNode root, int k) {
        if(root == null || k < 0){
            return -1;
        }
        try{
            helper(root, k);
        }catch(RuntimeException e){
        }
        return ans;
    }

    public void helper(TreeNode node, int k){
        if(node == null){
            return;
        }
        helper(node.right, k);
        now++;
        if(now == k){
            ans = node.val;
            throw new RuntimeException("");
        }
        helper(node.left, k);
    }
}
