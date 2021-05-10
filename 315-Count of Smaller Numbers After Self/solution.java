class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[] count = new int[n], indexes = new int[n];
        for (int i = 0; i < n; i++) {
            indexes[i] = i;
        }

        mergeSort(nums, count, indexes, 0, n - 1);

        List<Integer> ans = new ArrayList();
        for (int c : count) {
            ans.add(c);
        }

        return ans;
    }

    private void mergeSort(int[] nums, int[] count, int indexes[], int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = start + (end - start) / 2;
        mergeSort(nums, count, indexes, start, mid);
        mergeSort(nums, count, indexes, mid + 1, end);

        merge(nums, count, indexes, start, mid, end);
    }

    private void merge(int[] nums, int[] count, int[] indexes, int start, int mid, int end) {
        int[] res = new int[end - start + 1];
        int l = start, r = mid + 1, i = 0, rCount = 0;

        while (l <= mid && r <= end) {
            if (nums[indexes[l]] <= nums[indexes[r]]) {// left <= right
                count[indexes[l]] += rCount;
                res[i++] = indexes[l++];
            } else {// right < left
                rCount++;
                res[i++] = indexes[r++];
            }
        }

        while (l <= mid) {
            count[indexes[l]] += rCount;
            res[i++] = indexes[l++];
        }

        while (r <= end) {
            res[i++] = indexes[r++];
        }

        System.arraycopy(res, 0, indexes, start, end - start + 1);
    }
}