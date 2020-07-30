package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null)
            return res;
        Stack<TreeNode> evenStack = new Stack<TreeNode>();
        Stack<TreeNode> oddStack = new Stack<TreeNode>();
        evenStack.push(root);
        for (int i = 0; !evenStack.isEmpty() || !oddStack.isEmpty(); i++) {
            List<Integer> tmp = new ArrayList<Integer>();
//            偶数层
            if ((i & 1) == 0) {
                while (!evenStack.isEmpty()) {
                    TreeNode node = evenStack.pop();
                    tmp.add(node.val);
                    if (node.left != null)
                        oddStack.push(node.left);
                    if (node.right != null)
                        oddStack.push(node.right);
                }
            } else {
//                奇数层
                while (!oddStack.isEmpty()) {
                    TreeNode node = oddStack.pop();
                    tmp.add(node.val);
                    if (node.right != null)
                        evenStack.push(node.right);
                    if (node.left != null)
                        evenStack.push(node.left);
                }
            }
            res.add(tmp);
        }
        return res;
    }
}
