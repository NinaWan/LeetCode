class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        int m = restrictions.length;
        int[][] rArr = new int[m + 2][2];
        rArr[m] = new int[] {1, 0};
        rArr[m + 1] = new int[] {n, n - 1};

        System.arraycopy(restrictions, 0, rArr, 0, m);
        Arrays.sort(rArr, (a, b) -> a[0] - b[0]);

        // shave restrictions from left to right
        for (int i = 0; i < rArr.length - 1; i++) {
            int h1 = rArr[i][1], h2 = rArr[i + 1][1];
            int x = rArr[i][0], y = rArr[i + 1][0];
            int h = h1 + y - x;
            if (h > h2) {
                h = h2 + (h - h2) / 2;
            }
            rArr[i + 1][1] = Math.min(h, h2);
        }

        int ans = 0;
        // shave restrictions from right to left
        for (int i = rArr.length - 1; i > 0; i--) {
            int h1 = rArr[i][1], h2 = rArr[i - 1][1];
            int x = rArr[i][0], y = rArr[i - 1][0];
            int h = h1 + x - y;
            if (h > h2) {
                h = h2 + (h - h2) / 2;
            }
            ans = Math.max(ans, h);
            rArr[i - 1][1] = Math.min(h, h2);
        }

        return ans;
    }
}