class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};

        if (null == nums || nums.length == 0) {
            return result;
        }

        int start = 0, end = nums.length - 1;

        // find the first position
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                if (mid == 0 || nums[mid - 1] != target) {
                    result[0] = mid;
                    break;
                } else {
                    end = mid;
                    continue;
                }
            }

            if (nums[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }


        if (nums[end] == target && result[0] == -1) {
            result[0] = end;
        }

        if (nums[start] == target) {
            result[0] = start;
        }

        // find the last position
        start = 0;
        end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                if (mid == nums.length - 1 || nums[mid + 1] != target) {
                    result[1] = mid;
                    break;
                } else {
                    start = mid;
                    continue;
                }
            }

            if (nums[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (nums[start] == target && result[1] == -1) {
            result[1] = start;
        }

        if (nums[end] == target) {
            result[1] = end;
        }

        return result;
    }
}