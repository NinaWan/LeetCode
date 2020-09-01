class Solution {
    public int compareVersion(String version1, String version2) {
        String[] nums1 = version1.split("\\.");
        String[] nums2 = version2.split("\\.");

        for (int i = 0; i < Math.max(nums1.length, nums2.length); i++) {
            if (i < nums1.length && i < nums2.length) {
                int num1 = Integer.valueOf(nums1[i]);
                int num2 = Integer.valueOf(nums2[i]);
                if (num1 > num2) {
                    return 1;
                } else if (num2 > num1) {
                    return -1;
                }
            } else if (i < nums1.length) {
                if (Integer.valueOf(nums1[i]) != 0) {
                    return 1;
                }
            } else {
                if (Integer.valueOf(nums2[i]) != 0) {
                    return -1;
                }
            }
        }

        return 0;
    }
}