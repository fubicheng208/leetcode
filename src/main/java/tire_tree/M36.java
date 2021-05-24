package tire_tree;

public class M36 {

    // https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/
//    输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。
    Node pre, head;
    public Node treeToDoublyList(Node root) {
        if(root == null)
            return null;
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    public void dfs(Node cur){
        if(cur == null){
            return;
        }
        dfs(cur.left);
        if(pre == null){
            head = cur;
        }else{
            pre.right = cur;
        }
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }

    class Node{
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int val){
            this.val = val;
        }
    }
}
