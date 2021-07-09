class Solution {
    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int f2 = 0, f1 = 1;
        for (int i = 2; i <= n; i++) {
            int tmp = f1 + f2;
            f2 = f1;
            f1 = tmp;
        }

        return f1;
    }
}