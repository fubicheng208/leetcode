package string;

/**
 * @author fubic
 * @date 2021-01-31
 */
public class Jindian01_04 {
/*    给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
    回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
    回文串不一定是字典当中的单词。

    示例1：
    输入："tactcoa"
    输出：true（排列有"tacocat"、"atcocta"，等等）*/

    public boolean canPermutePalindrome(String s) {
        int[] cnt = new int[128];
        for(Character c : s.toCharArray()){
            int index = c;
            cnt[index] = Math.abs(cnt[index] - 1);
        }
        int sum = 0;
        for(int t : cnt){
            sum += t;
        }
        if(s.length() % 2 == 0){
            return sum == 0;
        }else{
            return sum == 1;
        }
    }
}
