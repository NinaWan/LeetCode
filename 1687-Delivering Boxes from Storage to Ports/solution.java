class Solution {
    public int boxDelivering(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
        int n = boxes.length;
        int[] dp = new int[n + 1];
        int cost = 0;

        for (int i = 0, j = 0, lastJ = 0; i < n; i++) {
            while (j < n && maxWeight >= boxes[j][1] && maxBoxes > 0) {
                maxWeight -= boxes[j][1];
                maxBoxes--;
                if (j == 0 || boxes[j][0] != boxes[j - 1][0]) {
                    lastJ = j;
                    cost++;
                }
                dp[++j] = 200000;
            }

            dp[j] = Math.min(dp[j], dp[i] + cost + 1);
            dp[lastJ] = Math.min(dp[lastJ], dp[i] + cost);

            maxWeight += boxes[i][1];
            maxBoxes++;

            if (i < n - 1 && boxes[i][0] != boxes[i + 1][0]) {
                cost--;
            }
        }

        return dp[n];
    }
}