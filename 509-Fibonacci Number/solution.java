class Solution {
    public int fib(int N) {
        if (N == 0 || N == 1) {
            return N;
        }

        int fp = 1;
        int fpp = 0;
        int f = fp;

        while (N > 1) {
            f = fp + fpp;
            int temp = fp;
            fp = f;
            fpp = temp;
            N--;
        }

        return f;
    }
}