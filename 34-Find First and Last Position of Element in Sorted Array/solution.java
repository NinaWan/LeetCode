class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[] {-1, -1};
        }

        int start = 0;
        int end = nums.length - 1;
        int[] result = new int[2];
        int mid = 0;
        Arrays.fill(result, -1);

        // find the first position
        while (start + 1 < end) {
            mid = start + (end - start) / 2;

            if (nums[mid] == target && (mid == 0 || nums[mid - 1] != target)) {
                result[0] = mid;
                break;
            }

            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        if (result[0] == -1) {
            result[0] = nums[start] == target ? start
                                              : nums[end] == target ? end
                                                                    : -1;
        }

        start = 0;
        end = nums.length - 1;

        // find the last position
        while (start + 1 < end) {
            mid = start + (end - start) / 2;

            if (nums[mid] == target && (mid == nums.length - 1 || nums[mid + 1] != target)) {
                result[1] = mid;
                break;
            }

            if (nums[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        if (result[1] == -1) {
            result[1] = nums[end] == target ? end
                                            : nums[start] == target ? start
                                                                    : -1;
        }

        return result;
    }
}