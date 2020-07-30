package array;

class Solution409 {
    public int longestPalindrome(String s) {
        int[] times = new int[80];
        for (char c : s.toCharArray()) {
            times[c - 'A']++;
        }
        int res = 0;
        int flagOdd = 0;
        for (int i : times) {
            if (i != 0) {
                if (i % 2 == 0) {
                    res += i;
                } else {
                    flagOdd = 1;
                    res += i / 2 * 2;
                }
            }
        }
        return res + flagOdd;
    }
}