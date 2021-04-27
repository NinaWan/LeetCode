class Solution {
    public int clumsy(int N) {
        if (N < 3) {
            return N;
        }

        int ans = 2 * (N * (N - 1) / (N - 2));
        while (N > 2) {
            ans -= N * (N - 1) / (N - 2);
            ans += N - 3;
            N -= 4;
        }

        return N > 0 ? ans - N
                     : ans;
    }
}