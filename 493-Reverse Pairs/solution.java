class Solution {
    public int reversePairs(int[] nums) {
        return countWithSort(nums, 0, nums.length - 1);
    }

    private int countWithSort(int[] nums, int start, int end) {
        if (start >= end) {
            return 0;
        }

        int mid = start + (end - start) / 2;
        int count = countWithSort(nums, start, mid) + countWithSort(nums, mid + 1, end);
        int[] sorted = new int[end - start + 1];
        int i = 0;

        for (int l = start, r = mid + 1, j = mid + 1; l <= mid; l++) {
            while (r <= end && nums[l] / 2.0 > nums[r]) {
                r++;
            }
            count += r - mid - 1;

            // merge left and right
            while (j <= end && nums[j] < nums[l]) {
                sorted[i++] = nums[j++];
            }
            sorted[i++] = nums[l];
        }

        System.arraycopy(sorted, 0, nums, start, i);

        return count;
    }
}