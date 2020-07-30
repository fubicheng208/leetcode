package stack;

import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;

import java.util.Stack;

/*根据逆波兰表示法，求表达式的值。

        有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。

        说明：

        整数除法只保留整数部分。
        给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
        示例 1：

        输入: ["2", "1", "+", "3", "*"]
        输出: 9
        解释: ((2 + 1) * 3) = 9*/


public class Solution150 {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0)
            return 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (String s : tokens) {
            int t;
            if (s.equals("+"))
                stack.push(stack.pop() + stack.pop());
            else if (s.equals("-")) {
                int tmp = stack.pop();
                stack.push(stack.pop() - tmp);
            } else if (s.equals("*"))
                stack.push(stack.pop() * stack.pop());
            else if (s.equals("/")) {
                int tmp = stack.pop();
                stack.push(stack.pop() / tmp);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.peek();
    }
}
