class Solution {
    public int minDistance(int[] houses, int k) {
        int n = houses.length;
        int[][] minDist = new int[n][n]; // the mininum total distance to allocate k=1 mailbox among houses[i:j]
        int[][] dump = new int[k][n];

        for (int i = 0; i < k; i++) {
            Arrays.fill(dump[i], -1);
        }
        Arrays.sort(houses);

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                minDist[i][j] = houses[j] - houses[i] + minDist[i + 1][j - 1];
            }
        }

        return minDistance(k, 0, n, minDist, dump);
    }

    private int minDistance(int k, int i, int n, int[][] minDist, int[][] dump) {
        if (k == 0 && i == n) {
            return 0;
        }

        if (k == 0 || i == n) {
            return (int) 1e6;
        }

        if (dump[k - 1][i] != -1) {
            return dump[k - 1][i];
        }

        int ans = (int) 1e6;
        for (int j = i; j < n; j++) {
            ans = Math.min(ans, minDist[i][j] + minDistance(k - 1, j + 1, n, minDist, dump));
        }

        return dump[k - 1][i] = ans;
    }
}