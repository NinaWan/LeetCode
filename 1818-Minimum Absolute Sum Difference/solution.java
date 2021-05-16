class Solution {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int mod = (int) 1e9 + 7, n = nums1.length;
        long ans = 0;
        TreeSet<Integer> set = new TreeSet();
        for (int i = 0; i < n; i++) {
            ans = Math.abs(nums1[i] - nums2[i]) + ans;
            set.add(nums1[i]);
        }

        int diff = 0;
        for (int i = 0; i < n; i++) {
            int original = Math.abs(nums1[i] - nums2[i]);
            if (diff < original) {// possible get smaller sum by replacing current element
                Integer floor = set.floor(nums2[i]);
                Integer ceiling = set.ceiling(nums2[i]);
                if (floor != null) {
                    diff = Math.max(diff, original - Math.abs(floor - nums2[i]));
                }
                if (ceiling != null) {
                    diff = Math.max(diff, original - Math.abs(ceiling - nums2[i]));
                }
            }
        }

        return (int) ((ans - diff) % mod);
    }
}