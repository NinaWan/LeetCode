class Solution {
    public double new21Game(int n, int k, int maxPts) {
        if (k == 0 || k - 1 + maxPts <= n) {
            return 1;
        }

        // p(i) = p(i-1)/maxPts+p(i-2)/maxPts+...+p(i-maxPts)/maxPts;
        // let sum = p(i-1)+p(i-2)+...+p(i-maxPts), thus p(i) = sum/maxPts
        double[] dp = new double[n + 1];// dp[i] -> p(i)
        dp[0] = 1;
        double sum = 1, ans = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = sum / maxPts;
            if (i < k) {
                sum += dp[i];
            } else {
                ans += dp[i];
            }

            if (i >= maxPts) {
                sum -= dp[i - maxPts];
            }
        }

        return ans;
    }
}