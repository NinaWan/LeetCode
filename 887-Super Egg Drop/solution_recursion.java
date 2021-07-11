class Solution {
    public int superEggDrop(int k, int n) {
        return superEggDrop(k, n, new int[k + 1][n + 1]);
    }

    public int superEggDrop(int k, int n, int[][] memo) {
        if (k == 1) {// only one egg
            return n;
        }

        if (n == 0) {// no floor
            return 0;
        }

        if (memo[k][n] != 0) {
            return memo[k][n];
        }

        int res = Integer.MAX_VALUE;
        int lo = 1, hi = n;
        // for(int i=1; i<=n; i++){
        // res = Math.min(res, Math.max(superEggDrop(k-1, i-1, memo), superEggDrop(k, n-i, memo))+1);// break or not break at
        // ith floor
        // }

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int broken = superEggDrop(k - 1, mid - 1, memo);// break at mid'th floor
            int notBroken = superEggDrop(k, n - mid, memo);// not break at mid'th floor

            res = Math.min(res, Math.max(broken, notBroken) + 1);

            if (broken < notBroken) {// pick up notBroken, need check higher floor
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return memo[k][n] = res;
    }
}