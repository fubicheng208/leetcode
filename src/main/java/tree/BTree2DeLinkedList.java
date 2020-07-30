package tree;

//输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
public class BTree2DeLinkedList {
    TreeNode pre = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null)
            return pRootOfTree;
        convert(pRootOfTree);
        while (pRootOfTree.left != null)
            pRootOfTree = pRootOfTree.left;
        return pRootOfTree;

    }

    public void convert(TreeNode node) {
        if (node == null)
            return;
        convert(node.left);

        node.left = pre;
        if (pre != null)
            pre.right = node;
        pre = node;

        convert(node.right);

    }

}
