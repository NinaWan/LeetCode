class Solution {
    public int maxValueAfterReverse(int[] nums) {
        int sum = 0;
        int minOf2 = Integer.MAX_VALUE;// the global min of max(a, b) for all possible pairs (a, b)
        int maxOf2 = Integer.MIN_VALUE; // the global max of min(a, b) for all possible pairs (a, b)
        int diff = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            sum += Math.abs(nums[i] - nums[i + 1]);

            // boundary case
            // reverse from head to i
            int diff1 = Math.abs(nums[0] - nums[i + 1]) - Math.abs(nums[i] - nums[i + 1]);
            // reverse from i+1 to tail
            int diff2 = Math.abs(nums[i] - nums[nums.length - 1]) - Math.abs(nums[i] - nums[i + 1]);
            diff = Math.max(diff, Math.max(diff1, diff2));

            // middle case
            minOf2 = Math.min(minOf2, Math.max(nums[i], nums[i + 1]));
            maxOf2 = Math.max(maxOf2, Math.min(nums[i], nums[i + 1]));
        }

        return sum + Math.max(diff, 2 * (maxOf2 - minOf2));
    }
}