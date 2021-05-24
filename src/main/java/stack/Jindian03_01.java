package stack;

/**
 * @author fubic
 * @date 2021-02-15
 */
public class Jindian03_01 {
/*    三合一。描述如何只用一个数组来实现三个栈。
    你应该实现push(stackNum, value)、pop(stackNum)、isEmpty(stackNum)、peek(stackNum)方法。stackNum表示栈下标，value表示压入的值。
    构造函数会传入一个stackSize参数，代表每个栈的大小。

    示例1:
    输入：
            ["TripleInOne", "push", "push", "pop", "pop", "pop", "isEmpty"]
            [[1], [0, 1], [0, 2], [0], [0], [0], [0]]
    输出：
            [null, null, null, 1, -1, -1, true]
    说明：当栈为空时`pop, peek`返回-1，当栈满时`push`不压入元素。
    示例2:
    输入：
            ["TripleInOne", "push", "push", "push", "pop", "pop", "pop", "peek"]
            [[2], [0, 1], [0, 2], [0, 3], [0], [0], [0], [0]]
    输出：
            [null, null, null, null, 2, 1, -1, -1]*/


    // index指向当前栈顶位置
    private int[] index = {-1, -1, -1};
    private int[][] stack;

    public Jindian03_01(int stackSize) {
        this.stack = new int[3][stackSize];
    }

    public void push(int stackNum, int value) {
        if(index[stackNum] >= stack[0].length - 1){
            return;
        }else{
            stack[stackNum][++index[stackNum]] = value;
        }
    }

    public int pop(int stackNum) {
        return index[stackNum] < 0 ? -1 : stack[stackNum][index[stackNum]--];
    }

    public int peek(int stackNum) {
        return index[stackNum] < 0 ? -1 : stack[stackNum][index[stackNum]];
    }

    public boolean isEmpty(int stackNum) {
        return index[stackNum] < 0 ? true : false;
    }
}
