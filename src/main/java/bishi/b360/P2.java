package bishi.b360;

import com.sun.prism.shader.Solid_TextureYV12_AlphaTest_Loader;

import java.util.Scanner;

public class P2 {

/*    1.要有数字

2.要有大写字母

3.要有小写字母

4.要有特殊字符

5.长度不得小于8

    Ok，否则输出Irregular password*/

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            if (s.length() < 8 || !check(s)) {
                System.out.println("Irregular password");
            } else {
                System.out.println("Ok");
            }
        }
    }

    public static boolean check(String s) {
        boolean hasNumber = false;
        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasSpecial = false;
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                hasNumber = true;
            } else if (c >= 'a' && c <= 'z') {
                hasLower = true;
            } else if (c >= 'A' && c <= 'Z') {
                hasUpper = true;
            } else {
                hasSpecial = true;
            }
        }
        return hasNumber && hasUpper && hasLower && hasSpecial;
    }
}
