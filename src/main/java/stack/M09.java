package stack;

import java.util.Stack;

/*        用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
        示例 1：
        输入：
        ["CQueue","appendTail","deleteHead","deleteHead"]
        [[],[3],[],[]]
        输出：[null,null,3,-1]
        https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/submissions/
        */

public class M09 {
    private Stack<Integer> s1;
    private Stack<Integer> s2;
    int size = 0;

    public M09() {
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();
    }

    public void appendTail(int value) {
        s1.push(value);
        size++;
    }

    public int deleteHead() {
        if(size == 0)
            return -1;
        //如果s2不为空，则直接返回s2栈顶即可
        //如果s2为空，则把s1的倒过来
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        size--;
        return s2.pop();
    }
}
