class Solution {
    int[][] memo;

    public int numTrees(int n) {
        memo = new int[n + 1][n + 1];
        return countTree(1, n);
    }

    private int countTree(int lo, int hi) {
        if (lo > hi) {
            return 1;
        }

        if (memo[lo][hi] != 0) {
            return memo[lo][hi];
        }

        int res = 0;
        for (int i = lo; i <= hi; i++) {
            int left = countTree(lo, i - 1);
            int right = countTree(i + 1, hi);
            res += left * right;
        }

        memo[lo][hi] = res;
        return res;
    }
}