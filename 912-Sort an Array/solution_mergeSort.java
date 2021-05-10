class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void mergeSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = start + (end - start) / 2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);

        merge(nums, start, mid, end);
    }

    private void merge(int[] nums, int start, int mid, int end) {
        int[] res = new int[end - start + 1];
        int l = start, r = mid + 1, i = 0;

        while (l <= mid && r <= end) {
            if (nums[l] < nums[r]) {
                res[i++] = nums[l++];
            } else {
                res[i++] = nums[r++];
            }
        }

        while (l <= mid) {
            res[i++] = nums[l++];
        }

        while (r <= end) {
            res[i++] = nums[r++];
        }

        for (int j = 0; j < end - start + 1; j++) {
            nums[j + start] = res[j];
        }
    }
}