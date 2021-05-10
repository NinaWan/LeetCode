class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] preSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        return countWithSort(preSum, 0, n, lower, upper);
    }

    private int countWithSort(long[] preSum, int start, int end, int lower, int upper) {
        if (start >= end) {
            return 0;
        }

        int mid = start + (end - start) / 2;
        long[] sorted = new long[end - start + 1];
        int count = countWithSort(preSum, start, mid, lower, upper) + countWithSort(preSum, mid + 1, end, lower, upper);
        int r = mid + 1;
        for (int i = start, j = mid + 1, k = mid + 1, x = 0; i <= mid; i++) {// for each preSum in left half
            while (k <= end && preSum[k] - preSum[i] < lower) {
                k++;
            }
            while (j <= end && preSum[j] - preSum[i] <= upper) {
                j++;
            }
            count += j - k;

            // merge left and right
            while (r <= end && preSum[r] < preSum[i]) {
                sorted[x++] = preSum[r++];
            }
            sorted[x++] = preSum[i];
        }

        System.arraycopy(sorted, 0, preSum, start, r - start);

        return count;
    }
}