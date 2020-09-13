package bishi.laohu;

import java.util.ArrayList;
import java.util.List;

public class P2 {
    /**
     * @param expression string字符串
     * @return int整型
     */
    public static int getMaxResult(String expression) {
        // write code here
        String[] aS = expression.split("[+-]");
        List<Character> op = new ArrayList<>();
        for (char c : expression.toCharArray()) {
            if (!(c >= '0' && c <= '9')) {
                op.add(c);
            }
        }
        List<Integer> a = new ArrayList<>();
        for (String s : aS) {
            a.add(Integer.parseInt(s));
        }



/*        for(Character s : op){
            System.out.println(s);
        }*/
        return 1;
    }

    public static void compress(List<Character> op, List<Integer> a) {
        int i = 0;
        for (int j = 1; j < a.size(); j++) {
            if (op.get(i).equals('+') && op.get(j).equals('+')) {
                a.set(i, a.get(i) + a.get(j));
            } else {
                i++;
                op.set(i, op.get(j));
                a.set(i, a.get(j));
            }
        }
    }

    public static int result(List<Character> op, List<Integer> a) {
        compress(op, a);
        int[] max = new int[a.size()];
        int[] suffix = new int[a.size()];

        suffix[suffix.length - 1] = a.get(suffix.length - 1);
        for (int i = suffix.length - 2; i >= 0; i--) {
            suffix[i] = a.get(i) + suffix[i + 1];
        }
        max[a.size() - 1] = a.get(a.size() - 1);
        for (int i = a.size() - 2; i >= 0; i--) {
            if (op.get(i + 1).equals('+')) {
                max[i] = max[i + 1] + a.get(i);
            } else {
                if (i + 2 >= a.size()) {
                    max[i] = a.get(i) - a.get(i + 1);
                    continue;
                }
                if (op.get(i + 2).equals('-')) {
                    max[i] = a.get(i) - a.get(i + 1) + suffix[i + 2];
                } else {
                    int s = a.get(i) - a.get(i + 1) - a.get(i + 2) + (i + 3 < suffix.length ? suffix[i + 3] : 0);
                    int ss = a.get(i) - a.get(i + 1) + max[i + 2];
                    max[i] = Math.max(s, ss);
                }

            }

        }
        return max[0];

    }


    public static void main(String[] args) {
        String e = "1-2-3+4";
        System.out.println(getMaxResult(e));
    }
}