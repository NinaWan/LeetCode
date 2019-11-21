class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int sum = 0;
        int diff = Integer.MAX_VALUE;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int[] twoSumResult = twoSumClosest(nums, target - nums[i], i + 1, nums.length - 1);
            if (twoSumResult[0] < diff) {
                diff = twoSumResult[0];
                sum = nums[i] + twoSumResult[1];
            }
        }

        return sum;
    }

    public int[] twoSumClosest(int[] nums, int target, int start, int end) {
        int[] result = new int[2];
        result[0] = Integer.MAX_VALUE;

        for (int i = start, j = end; i < j; ) {
            if (nums[i] + nums[j] == target) {
                result[0] = 0;
                result[1] = nums[i] + nums[j];
                return result;
            }

            int currSum = nums[i] + nums[j];
            int currDiff = Math.abs(currSum - target);
            if (currDiff < result[0]) {
                result[0] = currDiff;
                result[1] = currSum;
            }

            if (currSum < target) {
                i++;
            } else {
                j--;
            }
        }

        return result;
    }
}