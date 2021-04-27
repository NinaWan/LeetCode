class Solution {
    public int[] waysToFillArray(int[][] queries) {
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
        int mod = (int) 1e9 + 7;
        int[] ans = new int[queries.length];
        Arrays.fill(ans, 1);
        int[][] combinations = new int[100013][14];// 13 stars at most, [total position count, star count]
        combinations[0][0] = 1;

        for (int p = 1; p < combinations.length; p++) {
            for (int s = 0; s < 14; s++) {
                combinations[p][s] = s == 0 ? 1
                                            : (combinations[p - 1][s - 1] + combinations[p - 1][s]) % mod;
            }
        }

        for (int i = 0; i < queries.length; i++) {
            int n = queries[i][0], k = queries[i][1];
            for (int prime : primes) {
                int starCount = 0;// number of current primeas factor of k
                int barCount = n - 1;
                while (k % prime == 0) {
                    starCount++;
                    k /= prime;
                }

                ans[i] = (int) ((long) ans[i] * combinations[barCount + starCount][starCount] % mod);
            }

            if (k != 1) {// if has and only has one prime factor which is larger than 100
                ans[i] = (int) ((long) ans[i] * n % mod);
            }
        }

        return ans;
    }
}