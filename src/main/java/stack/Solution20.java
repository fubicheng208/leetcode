package stack;

import java.util.HashMap;
import java.util.Stack;

public class Solution20 {
    private HashMap<Character, Character> hm;

    public Solution20() {
        hm = new HashMap<Character, Character>();
        hm.put(')', '(');
        hm.put('}', '{');
        hm.put(']', '[');
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (hm.containsKey(c)) {
                if (!stack.isEmpty() && stack.peek() == hm.get(c))
                    stack.pop();
                else
                    return false;
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
