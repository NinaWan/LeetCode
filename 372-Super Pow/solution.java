class Solution {
    public int superPow(int a, int[] b) {
        int ans = 1;
        int divisor = 1337;

        for (int i = b.length - 1; i >= 0; i--) {
            ans = ans * pow(a, b[i], divisor) % divisor;
            a = pow(a, 10, divisor);
        }

        return ans;
    }

    private int pow(int base, int exponent, int divisor) {
        int res = 1;
        base = base % divisor;

        while (exponent > 0) {
            res = res * base % divisor;
            exponent--;
        }

        return res;
    }
}