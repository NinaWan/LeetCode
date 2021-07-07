class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int lo = 0, hi = 0;
        for (int weight : weights) {
            lo = Math.max(lo, weight);
            hi += weight;
        }

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int needed = calculateDaysNeeded(mid, weights);
            if (needed > days) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        return lo;
    }

    private int calculateDaysNeeded(int cap, int[] weights) {
        int res = 0, loading = 0;
        for (int weight : weights) {
            loading += weight;

            if (loading > cap) {
                res++;
                loading = weight;
            }
        }

        return res + 1;
    }
}