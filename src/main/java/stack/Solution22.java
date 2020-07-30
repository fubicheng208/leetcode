package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution22 {
//    List<String> res = new ArrayList<>();
//    public List<String> generateParenthesis(int n) {
//        Stack<Character> stack = new Stack<>();
//        if(n==0)
//            return res;
//        stack.push('(');
//        String s = "(";
//        int now = n-1;
//        cal(now, stack, s);
//        return res;
//    }
//
//    public void cal(int now, Stack<Character> stack,String s){
//        if(now==0 && stack.isEmpty()){
//            res.add(s);
//            return;
//        }
//        Stack<Character> tmp = (Stack<Character>) stack.clone();
//        if(stack.isEmpty()){
//            stack.push('(');
//            cal(now-1, stack, s + "(");
//        }else {
//            if (now != 0) {
//                stack.push('(');
//                cal(now-1, stack, s + "(");
//            }
//            stack = tmp;
//            stack.pop();
//            cal(now, stack, s+")");
//        }
//    }

    // 做减法

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        // 特判
        if (n == 0) {
            return res;
        }

        // 执行深度优先遍历，搜索可能的结果
        dfs("", n, n, res);
        return res;
    }

    public void dfs(String curStr, int l, int r, List<String> res) {
        if (l == 0 && r == 0) {
            res.add(curStr);
            return;
        }
        if (l > r)
            return;
        if (l > 0)
            dfs(curStr + "(", l - 1, r, res);
        if (r > 0)
            dfs(curStr + ")", l, r - 1, res);
    }


    public static void main(String[] args) {
        System.out.println(new Solution22().generateParenthesis(2));
    }

}
