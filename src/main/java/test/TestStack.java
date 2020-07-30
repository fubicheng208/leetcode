package test;

import java.util.HashMap;
import java.util.Stack;

public class TestStack {
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        Stack<Integer> stack2 = (Stack<Integer>) stack.clone();

        stack2.push(3);
        while (!stack2.isEmpty()) {
            System.out.println(stack2.pop());
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
        System.out.println(stack.capacity());
    }
}
