package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author fubic
 * @date 2021-02-24
 */
public class Jindian0402 {

/*    给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。

    示例:
    给定有序数组: [-10,-3,0,5,9],

    一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：

            0
            / \
            -3   9
            /   /
            -10  5*/


    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    public TreeNode build(int[] nums, int l, int r){
        if(l > r){
            return null;
        }else{
            int len = r - l + 1;
            int mid;
            if(len % 2 == 0){
                mid = (l + r) / 2 + 1;
            }else{
                mid = (l + r) / 2;
            }
            TreeNode node = new TreeNode(nums[mid]);
            node.left = build(nums, l , mid - 1);
            node.right = build(nums, mid + 1, r);
            return node;
        }
    }
}
