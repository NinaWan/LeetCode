class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int start = 1;
        int end = Arrays.stream(nums).max().getAsInt();
        while (start < end) {
            int mid = start + (end - start) / 2;
            int sum = getDivisionSum(nums, mid);
            if (sum > threshold) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return start;
    }

    private int getDivisionSum(int[] nums, int divisor) {
        return Arrays.stream(nums).map(num -> (int) Math.ceil((double) num / divisor)).sum();
    }
}