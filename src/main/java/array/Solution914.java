package array;

import com.sun.javafx.runtime.async.AbstractRemoteResource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution914 {
    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (Integer i : deck) {
            if (!hm.containsKey(i)) {
                hm.put(i, 1);
            } else {
                hm.put(i, hm.get(i) + 1);
            }
        }

        List<List<Integer>> ls = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            Integer count = entry.getValue();
            if (count == 1)
                return false;
            List<Integer> tmp = getFactors(count);
            ls.add(tmp);
        }

        List<Integer> lsFirst = ls.get(0);
        for (List<Integer> tmp : ls) {
            lsFirst.retainAll(tmp);
        }

        if (lsFirst.size() > 0)
            return true;
        else
            return false;

    }

    public List<Integer> getFactors(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (n % i == 0)
                res.add(i);
        }
        return res;
    }
}
