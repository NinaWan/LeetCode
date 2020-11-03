class Solution {
    public double myPow(double x, int n) {
        if (x == 1 || x == -1) {
            return n % 2 == 0 ? 1.0
                              : x;
        }

        double ans = 1.0;
        for (long i = 0; i < Math.abs((long) n); i++) {
            if (n >= 0) {
                ans *= x;
            } else {
                ans /= x;
                if (ans == 0) {
                    break;
                }
            }
        }

        return ans;
    }
}