package tree;

import java.util.*;

public class M32 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int nums = queue.size();
            List<Integer> ls = new ArrayList<>();
            for(int i = 0; i<nums; i++){
                TreeNode tmp = queue.poll();
                ls.add(tmp.val);
                if(tmp.left != null)
                    queue.add(tmp.left);
                if(tmp.right != null)
                    queue.add(tmp.right);
            }
            res.add(ls);
        }
        return res;
    }
}
