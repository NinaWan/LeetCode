class Solution {
    public int maxValue(int n, int index, int maxSum) {
        maxSum -= n;
        int low = 0, high = maxSum;
        while (low < high) {
            int mid = low + (high - low + 1) / 2;
            if (minimumSum(n, index, mid) > maxSum) {
                high = mid - 1;
            } else {
                low = mid;
            }
        }

        return low + 1;
    }

    private long minimumSum(int n, int index, int peek) {
        int left = Math.max(0, peek - index);
        int right = Math.max(0, peek - (n - index - 1));
        return (long) (peek - left + 1) * (peek + left) / 2 + (long) (peek - right + 1) * (peek + right) / 2 - peek;
    }
}