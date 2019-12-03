class Solution {
    public int fib(int N) {
        if (N < 2) {
            return N;
        }

        int f1 = 0;
        int f2 = 1;
        for (int i = 2; i <= N; i++) {
            int temp = f1 + f2;
            f1 = f2;
            f2 = temp;
        }

        return f2;
    }
}