class Solution {
    public List<Integer> getRow(int rowIndex) {
        Integer[] dp = new Integer[rowIndex + 1];
        dp[0] = 1;

        for (int r = 1; r <= rowIndex; r++) {
            int pre = dp[0];
            int next = dp[1] == null ? 0 : dp[1];
            for (int c = 1; c < rowIndex + 1; c++) {
                if (c == rowIndex) {
                    dp[c] = 1;
                } else {
                    dp[c] = pre + next;
                    pre = next;
                    next = dp[c + 1] == null ? 0 : dp[c + 1];
                }
            }
        }

        return Arrays.asList(dp);
    }
}