class Solution {
    public boolean splitArraySameAverage(int[] A) {
        int sum = 0, n = A.length, k = n / 2;
        for (int num : A) {
            sum += num;
        }

        HashSet<Integer>[] dp = new HashSet[k + 1];// all possible sums of different sizes ending at each num in A
        for (int i = 0; i < dp.length; i++) {
            dp[i] = new HashSet();
        }
        dp[0].add(0);

        for (int i = 0; i < n; i++) {// subarray ends at A[i]
            for (int m = k; m >= 1; m--) { // the size of subarray is m
                for (int presum : dp[m - 1]) {
                    int subsum = A[i] + presum;
                    dp[m].add(subsum);
                    if (sum * m == subsum * n) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}