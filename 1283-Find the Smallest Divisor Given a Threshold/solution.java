class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1, high = (int) 1e6;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (getDivisionSum(nums, mid) <= threshold) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private int getDivisionSum(int[] nums, int divisor) {
        return Arrays.stream(nums).map(num -> (int) Math.ceil((double) num / divisor)).sum();
    }
}