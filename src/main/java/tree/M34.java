package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class M34 {

//    输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。

    LinkedList<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> tmp = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        helper(root, sum);
        return res;
    }

    public void helper(TreeNode node, int cnt) {
        if (node == null) {
            return;
        }
        tmp.add(node.val);
        cnt -= node.val;
        if (cnt == 0 && node.left == null && node.right == null) {
            res.add(new ArrayList(tmp));
        }
        helper(node.left, cnt);
        helper(node.right, cnt);
        tmp.removeLast();
    }
}
