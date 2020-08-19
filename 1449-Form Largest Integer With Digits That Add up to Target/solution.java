class Solution {
    public String largestNumber(int[] cost, int target) {
        BigInteger[] dp = new BigInteger[target + 1]; // for a specific target value (i.e. the array index), the largest integer can paint
        Arrays.fill(dp, new BigInteger("-1"));
        dp[0] = BigInteger.ZERO;

        for (int t = 1; t <= target; t++) {
            for (int i = 0; i < 9; i++) {
                int c = cost[i];
                if (t - c >= 0) {
                    dp[t] = dp[t].max(dp[t - c].multiply(BigInteger.TEN).add(new BigInteger(String.valueOf(i + 1))));
                }
            }
        }

        return String.valueOf(dp[target].max(BigInteger.ZERO));
    }
}