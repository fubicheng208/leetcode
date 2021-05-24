package search_tree;

import org.checkerframework.checker.units.qual.A;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author fubic
 * @date 2021-05-24
 */
public class BSTIterator2 {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /*TreeNode cur;
    Stack<TreeNode> stack;

    public BSTIterator2(TreeNode root){
        this.cur = root;
        stack = new Stack<>();
    }

    public int next(){
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

    int k;
    List<Integer> res;

    public BSTIterator2(TreeNode root){
        k = 0;
        res = new ArrayList<>();
        inorder(root);
    }

    public int next(){
        return res.get(k++);
    }

    public boolean hasNext(){
        return k < res.size();
    }

    public void inorder(TreeNode root){
        if(root == null){
            return;
        }
        inorder(root.left);
        res.add(root.val);
        inorder(root.right);
    }
}
