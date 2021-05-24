package stack;

import java.util.Stack;

/**
 * @author fubic
 * @date 2020-12-26
 */
public class M31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed == null || popped == null || pushed.length != popped.length){
            return false;
        }
        Stack<Integer> st = new Stack<>();
        int j = 0;
        for(int i = 0; i < pushed.length; i++){
            st.push(pushed[i]);
            //能出栈的全部出栈
            while(!st.isEmpty()){
                if(st.peek() == popped[j]){
                    st.pop();
                    j++;
                }else{
                    break;
                }
            }
        }
        if(st.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}
