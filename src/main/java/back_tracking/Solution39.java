package back_tracking;

import java.util.*;

public class Solution39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, candidates.length, 0, target, new ArrayDeque<>(), res);
        return res;
    }

    public void dfs(int[] candidates, int len, int begin, int rest, Deque<Integer> path, List<List<Integer>> res) {
        if (rest == 0) {
            res.add(new ArrayList(path));
            return;
        }
        for (int i = begin; i < len; i++) {
            //之后的candidates只会更大，所以必定小于0，可以直接剪枝
            if (rest - candidates[i] < 0)
                break;
            path.addLast(candidates[i]);
            //begin为i，因为可重复
            dfs(candidates, len, i, rest - candidates[i], path, res);
            path.removeLast();
        }
    }
}
