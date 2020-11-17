package tree;

public class M26 {

/*    输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
    B是A的子结构， 即 A中有出现和B相同的结构和节点值。*/
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        //AB是否以A为根节点为子结构；A的左子树是否包含B的结构；A的右子树是否包含B的结构
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    //结构是否相同
    public boolean recur(TreeNode a, TreeNode b){
        //说明子结构已经遍历完
        if(b == null){
            return true;
        }
        if(a == null || a.val != b.val){
            return false;
        }
        //判断a,b的左右是否均相等
        return recur(a.left,b.left) && recur(a.right, b.right);
    }
}
