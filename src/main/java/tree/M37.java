package tree;

import java.util.LinkedList;
import java.util.Queue;

public class M37 {

//    请实现两个函数，分别用来序列化和反序列化二叉树。
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "";
        }
        StringBuilder sb = new StringBuilder("[" + root.val);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode t = q.poll();
            if(t.left != null){
                q.add(t.left);
                sb.append("," + t.left.val);
            }else{
                sb.append(",null");
            }
            if(t.right != null){
                q.add(t.right);
                sb.append("," + t.right.val);
            }else{
                sb.append(",null");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0){
            return null;
        }
        String[] vals = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(!vals[i].equals("null")){
                TreeNode l = new TreeNode(Integer.parseInt(vals[i]));
                node.left = l;
                q.add(l);
            }
            i++;
            if(!vals[i].equals("null")){
                TreeNode r = new TreeNode(Integer.parseInt(vals[i]));
                node.right = r;
                q.add(r);
            }
            i++;
        }
        return root;
    }
}
