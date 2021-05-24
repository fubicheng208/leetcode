package bishi.tx2;

public class M1 {
    public static void main(String[] args) {

    }

    public int strToInt(String s) {
        int ten = 1;
        int res = 0;
        for (char c : s.toCharArray()) {
            res *= 10;
            res += c - '0';
        }
        return res;
    }
}
