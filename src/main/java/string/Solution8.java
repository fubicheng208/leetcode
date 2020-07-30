package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Solution8 {
    class Automaton {
        String state = "start";
        public int sign = 1;
        public long ans = 0;
        //start
        HashMap<String, String[]> table = new HashMap<>();

        Automaton() {
            table.put("start", new String[]{"start", "signed", "number", "end"});
            table.put("signed", new String[]{"end", "end", "number", "end"});
            table.put("number", new String[]{"end", "end", "number", "end"});
            table.put("end", new String[]{"end", "end", "end", "end"});
        }

        public int getCol(char c) {
            if (c == ' ')
                return 0;
            if (c == '+' || c == '-')
                return 1;
            if (c >= '0' && c <= '9')
                return 2;
            return 3;
        }

        public void get(char c) {
            state = table.get(state)[getCol(c)];
            if (state.equals("number")) {
                ans += ans * 10 + (c - '0');
                if (sign == 1)
                    ans = Math.min(ans, Integer.MAX_VALUE);
                else
                    ans = Math.min(ans, (long) -1 * Integer.MIN_VALUE);
            } else if (state.equals("signed")) {
                if (c == '+')
                    sign = 1;
                else
                    sign = -1;
            }
        }
    }

    public int myAtoi(String str) {
        Automaton automaton = new Automaton();
        for (char c : str.toCharArray()) {
            automaton.get(c);
        }
        return automaton.sign * (int) automaton.ans;
    }
//    public static int myAtoi(String str) {
//        str = str.trim();
//        List<Character> ls = new ArrayList<>();
////        List<Character> ls = str.chars().mapToObj(i->(char)i).filter(c -> c >= '0' && c<='9' || c=='-').collect(Collectors.toList());
//        boolean isFirstTag = true;
//        for(int i=0; i<str.length(); i++){
//            char c = str.charAt(i);
//            if(i==0 && !((c>= '0' && c<='9') || (c=='-' && isFirstTag) || ( c=='+' && isFirstTag))
//                return 0;
//            if((c>= '0' && c<='9') || c=='-')
//                ls.add(c);
//            else
//                break;
//        }
//        if(ls.size()==0)
//            return 0;
//        while(ls.lastIndexOf('-') != -1 && ls.lastIndexOf('-') != 0){
//            ls.remove(ls.lastIndexOf('-'));
//        }
//        long ans = 0;
//        int flag = 1;
//        for(int i=0 ;i<ls.size(); i++){
//            if(ls.get(i)=='-'){
//                flag = -1;
//                continue;
//            }
//            if(ls.get(i)=='+')
//
//            ans *= 10;
//            ans += ls.get(i)-'0';
//            if(ans > Integer.MAX_VALUE){
//                return flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
//            }
//        }
//        return flag * (int)ans;
//    }


//    public static void main(String[] args) {
//        System.out.println(myAtoi("3.14159"));
//    }
}
