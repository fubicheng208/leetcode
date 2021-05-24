package bishi.bilibili;

public class P3 {
    public int GetFragment(String str) {
        // write code here
        if (str == null || str.length() == 0)
            return 0;
        char c = str.charAt(0);
        int cnt = 1;
        for (char ch : str.toCharArray()) {
            if (ch != c) {
                cnt++;
                c = ch;
            }
        }
        return str.length() / cnt;
    }
}
