package maths;

public class Gcd {
    public static int gcd(int x, int y) {
        return x == 0 ? y : gcd(y % x, x);
    }
}
