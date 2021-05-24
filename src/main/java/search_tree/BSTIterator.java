package search_tree;

import com.sun.deploy.panel.ITreeNode;

import java.util.*;

/**
 * @author fubic
 * @date 2021-05-23
 */
public class BSTIterator {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    //法一：栈递归
/*    TreeNode cur;
    //Deque<TreeNode> stack = new LinkedList<>();
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        this.cur = root;
    }

    public int next() {
        while(cur != null){
            stack.push(cur);
            cur = cur.left;
        }
        cur = stack.pop();
        int res = cur.val;
        cur = cur.right;
        return res;
    }

    public boolean hasNext(){
        return cur != null || !stack.isEmpty();
    }*/

    //法二：维护中序遍历序列
    int idx = 0;
    List<Integer> arr;


    public BSTIterator(TreeNode root) {
        arr = new ArrayList<>();
        inorderTraverse(root);
    }

    public int next() {
        return arr.get(idx++);
    }

    public boolean hasNext(){
        return idx < arr.size();
    }

    public void inorderTraverse(TreeNode node){
        if(node == null){
            return;
        }
        inorderTraverse(node.left);
        arr.add(node.val);
        inorderTraverse(node.right);
    }
}
