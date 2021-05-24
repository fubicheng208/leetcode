package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author fubic
 * @date 2021-04-12
 */
public class Solution429 {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for(int i = 0; i < size; i++){
                Node node = q.poll();
                //当前层节点输入
                level.add(node.val);
                //下一层节点入队列
                q.addAll(node.children);
            }
            result.add(level);
        }
        return result;

    }

}
