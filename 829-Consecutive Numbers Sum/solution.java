class Solution {
    public int consecutiveNumbersSum(int N) {
        int ans = 0;
        int n = (int) Math.sqrt(2 * N);
        for (int i = 1; i <= n; i++) {
            int sum = i * (i - 1) / 2;
            if ((N - sum) % i == 0) {
                ans++;
            }
        }

        return ans;
    }
}