package stack;

import java.util.Stack;

public class M30 {
//    定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
    /** initialize your data structure here. */
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> stackMin = new Stack<>();
    public M30() {
        stack = new Stack<>();
        stackMin = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if(stackMin.size() == 0 || stackMin.peek() >= x)
            stackMin.push(x);
    }

    public void pop() {
        if(stackMin.peek().equals(stack.peek()))
            stackMin.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return stackMin.peek();
    }
}
