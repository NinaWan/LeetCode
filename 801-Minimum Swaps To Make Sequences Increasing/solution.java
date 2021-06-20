class Solution {
    public int minSwap(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int swap = 1, notSwap = 0;
        for (int i = 1; i < n; i++) {
            if (nums2[i] <= nums1[i - 1] || nums1[i] <= nums2[i - 1]) {// B[i]<=A[i-1] || A[i]<=B[i-1], keep same - both swap or not swap
                swap += 1;
            } else if (nums1[i] <= nums1[i - 1] || nums2[i] <= nums2[i - 1]) {// A[i]<=A[i-1] || B[i]<=B[i-1], keep different
                int tmp = notSwap;
                notSwap = swap;
                swap = tmp + 1;
            } else {// both are fine
                int min = Math.min(swap, notSwap);
                swap = min + 1;
                notSwap = min;
            }
        }

        return Math.min(swap, notSwap);
    }
}