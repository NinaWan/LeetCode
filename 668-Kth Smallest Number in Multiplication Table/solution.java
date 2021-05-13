class Solution {
    public int findKthNumber(int m, int n, int k) {
        int low = 1, high = m * n;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (numOfLessThan(mid, m, n) < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    private int numOfLessThan(int target, int m, int n) {
        int count = 0;

        for (int i = 1; i <= m; i++) {// for each row count the number which is less than target
            count += Math.min(target / i, n);
        }

        return count;
    }
}