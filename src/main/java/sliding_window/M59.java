package sliding_window;

import java.util.Deque;
import java.util.LinkedList;

public class M59 {
/*    1. 分为滑动窗口形成之前和之后来处理
    2. 形成之后：
    a. 首先移除左边
    b. 移除右边时要将队列中比他小的数都移除，以保证队列的非严格递减
    c. 将当前队列中的最大值加入结果中*/
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null)
            return new int[0];
        if(nums.length == 0 || k == 0)
            return new int[0];
        Deque<Integer> q = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        //滑动窗口还未形成之前
        for (int i = 0; i < k; i++) {
            while(!q.isEmpty() && nums[i] > q.peekLast()){
                q.removeLast();
            }
            q.addLast(nums[i]);
        }
        res[0] = q.peekFirst();
        //窗口形成之后只需要处理两个数
        for(int i = k; i < nums.length; i++){
            //左边的数如果是最大的，要移除（如果小于最大的，则肯定不在队列里）
            if(nums[i -k] == q.peekFirst()){
                q.removeFirst();
            }
            while(!q.isEmpty() && nums[i] > q.peekLast()){
                q.removeLast();
            }
            q.addLast(nums[i]);
            res[i - k + 1] = q.peekFirst();
        }
        return res;
    }


    public int[] maxSlidingWindow2(int[] nums, int k) {
        if(nums == null){
            return new int[0];
        }
        if(nums.length == 0 || k == 0){
            return new int[0];
        }
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> q = new LinkedList<>();
        //窗口形成之前
        for(int i = 0; i < k; i++){
            while(!q.isEmpty() && nums[i] > q.getLast()){
                q.removeLast();
            }
            q.addLast(nums[i]);
        }
        res[0] = q.getFirst();
        //窗口形成之后,只需要判断窗口左右两边数字
        for(int i = k; i < nums.length; i++){
            //左边
            if(nums[i - k] == q.getFirst()){
                q.removeFirst();
            }
            //右边
            while(!q.isEmpty() && nums[i] > q.getLast()){
                q.removeLast();
            }
            q.addLast(nums[i]);
            res[i - k + 1] = q.getFirst();
        }
        return res;
    }
}
