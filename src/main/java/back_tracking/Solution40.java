package back_tracking;

import com.google.common.collect.Lists;
import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author fubic
 * @date 2021-05-22
 */


/*给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

        candidates 中的每个数字在每个组合中只能使用一次。

        说明：

        所有数字（包括目标数）都是正整数。
        解集不能包含重复的组合。 
        示例 1:

        输入: candidates = [10,1,2,7,6,1,5], target = 8,
        所求解集为:
        [
        [1, 7],
        [1, 2, 5],
        [2, 6],
        [1, 1, 6]
        ]*/

public class Solution40 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0){
            throw new RuntimeException("candidates null");
//            return null;
        }
        Arrays.sort(candidates);
        traverse(candidates, new ArrayList<>(), 0, 0, target);
        return res;
    }

    public void traverse(int[] candidates, List<Integer> list, int nowIndex, int nowSum, int target){
        if(nowSum == target){
            List<Integer> record = new ArrayList<>(list);
            Collections.sort(record);
            if(!res.contains(record)){
                res.add(new ArrayList<>(list));
            }
            return;
        }else if(nowSum > target){
            return;
        }

        for(int i = nowIndex; i < candidates.length; i++){
            list.add(candidates[i]);
            traverse(candidates, list, i + 1, nowSum + candidates[i], target);
            list.remove(list.size() - 1);
        }
    }
}
