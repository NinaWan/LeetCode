class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        int low = 1, high = (int) 1e9;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (isValid(piles, H, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private boolean isValid(int[] piles, int H, int K) {
        int total = 0;

        for (int pile : piles) {
            total += pile / K;
            total += pile % K == 0 ? 0
                                   : 1;
        }

        return total <= H;
    }
}