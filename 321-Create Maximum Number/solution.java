class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        int[] ans = new int[k];

        for (int i = Math.max(0, k - n); i <= m && i <= k; i++) {
            ans = max(merge(maxArray(nums1, i), maxArray(nums2, k - i), k), ans);
        }

        return ans;
    }

    private int[] max(int[] nums1, int[] nums2) {
        if (greater(nums1, 0, nums2, 0)) {
            return nums1;
        }

        return nums2;
    }

    private int[] merge(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];

        for (int idx1 = 0, idx2 = 0, i = 0; i < k; i++) {
            res[i] = greater(nums1, idx1, nums2, idx2) ? nums1[idx1++]
                                                       : nums2[idx2++];
        }

        return res;
    }

    private boolean greater(int[] nums1, int idx1, int[] nums2, int idx2) {
        while (idx1 < nums1.length && idx2 < nums2.length && nums1[idx1] == nums2[idx2]) {
            idx1++;
            idx2++;
        }

        return idx2 == nums2.length || (idx1 < nums1.length && nums1[idx1] > nums2[idx2]);
    }

    private int[] maxArray(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[k];

        for (int i = 0, j = 0; i < n; i++) {
            while (j + n - i > k && j > 0 && res[j - 1] < nums[i]) {
                j--;
            }
            if (j < k) {
                res[j++] = nums[i];
            }
        }

        return res;
    }
}