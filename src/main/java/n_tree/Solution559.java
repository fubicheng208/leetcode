package n_tree;

/**
 * @author fubic
 * @date 2021-11-21
 */
public class Solution559 {

//    给定一个 N 叉树，找到其最大深度。
//
//    最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
//
//    N 叉树输入按层序遍历序列化表示，每组子节点由空值分隔（请参见示例）。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public int maxDepth(Node root) {
        if(root == null){
            return 0;
        }
        int max = 0;
        for(Node node : root.children){
            max = Math.max(max, maxDepth(node));
        }
        return max + 1;
    }
}
