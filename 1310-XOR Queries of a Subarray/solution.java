class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] result = new int[queries.length];
        int[] dp = new int[arr.length];
        dp[0] = arr[0];

        // initialization
        for (int i = 1; i < arr.length; i++) {
            dp[i] = dp[i - 1] ^ arr[i];
        }

        for (int i = 0; i < queries.length; i++) {
            if (queries[i][0] == queries[i][1]) {
                result[i] = arr[queries[i][0]];
            } else if (queries[i][0] == 0) {
                result[i] = dp[queries[i][1]];
            } else {
                result[i] = dp[queries[i][1]] ^ dp[queries[i][0] - 1];
            }
        }

        return result;
    }
}