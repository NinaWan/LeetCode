class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = (int) 1e9;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (isValid(piles, h, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private boolean isValid(int[] piles, int h, int k) {
        int total = 0;

        for (int pile : piles) {
            total += pile / k;
            total += pile % k == 0 ? 0
                                   : 1;
        }

        return total <= h;
    }
}