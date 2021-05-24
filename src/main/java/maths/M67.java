package maths;

public class M67 {
    //1. 处理首末空格
    //2. 处理正负号
    //3. 处理非数字
    //4. 处理越界
    //5. 处理数字构成
    public int strToInt(String str) {
        char[] cs = str.trim().toCharArray();
        if (cs.length == 0) {
            return 0;
        }
        int res = 0, bndry = Integer.MAX_VALUE / 10;
        int i = 0, sign = 1;
        if (cs[0] == '+') {
            i = 1;
        } else if (cs[0] == '-') {
            i = 1;
            sign = -1;
        }
        for (; i < cs.length; i++) {
            //如果不是数字
            if (cs[i] < '0' || cs[i] > '9') {
                break;
            }
            //如果是数字，还要处理越界问题
            if (res > bndry || (res == bndry && cs[i] > '7')) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + (cs[i] - '0');
        }
        return sign * res;
    }
}
