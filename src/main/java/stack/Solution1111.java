package stack;

public class Solution1111 {
    public int[] maxDepthAfterSplit(String seq) {

        int d = 0;
        int[] ans = new int[seq.length()];
        int now = 0;
        for (char c : seq.toCharArray()) {
            if (c == '(') {
                d++;
                ans[now++] = d & 1;//奇数d为0，偶数d为1
            }
            if (c == ')') {
                ans[now++] = d & 1;
                d--;
            }
        }
        return ans;
    }
}
