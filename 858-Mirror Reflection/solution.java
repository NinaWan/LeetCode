class Solution {
    public int mirrorReflection(int p, int q) {
        if (q == 0) {
            return 0;
        }

        // r*q = s*p, need to find the smallest r which satisfies this equation
        // r is the number of light reflection+1, thus
        // if r is odd, the final receptor could be 0 or 1, otherwise, it should be 2
        // s is the number of sides after extension
        // if s is odd, the final receptor is 1, otherwise, it is 0
        int r = p / gcd(p, q);
        int s = r * q / p;

        if (r % 2 == 0) {
            return 2;
        }

        return s % 2 == 0 ? 0
                          : 1;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}