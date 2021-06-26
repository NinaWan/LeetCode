class Solution {
    public double soupServings(int n) {
        if (n > 5000) {
            return 1;
        }

        return soupServings(n, n, new double[n + 1][n + 1]);
    }

    private double soupServings(int a, int b, double[][] dp) {
        if (a <= 0 && b <= 0) {// a and b become empty at the same time
            return 0.5;
        }

        if (a <= 0) {// a becomes empty first
            return 1.0;
        }

        if (b <= 0) {// b becomes empty first
            return 0.0;
        }

        if (dp[a][b] > 0) {
            return dp[a][b];
        }

        dp[a][b] = 0.25 * (soupServings(a - 100, b, dp) + soupServings(a - 75, b - 25, dp) + soupServings(a - 50, b - 50, dp) +
                soupServings(a - 25, b - 75, dp));

        return dp[a][b];
    }
}