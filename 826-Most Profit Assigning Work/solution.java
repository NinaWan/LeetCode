class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int ans = 0;
        int[][] jobs = new int[difficulty.length][2];

        for (int i = 0; i < difficulty.length; i++) {
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];
        }

        Arrays.sort(jobs, (int[] a, int[] b) -> {
            return a[0] - b[0];
        });
        Arrays.sort(worker);

        int max = 0;
        int p = 0;
        for (int w : worker) {
            while (p < jobs.length && w >= jobs[p][0]) {
                max = Math.max(max, jobs[p][1]);
                p++;
            }
            ans += max;
        }

        return ans;
    }
}