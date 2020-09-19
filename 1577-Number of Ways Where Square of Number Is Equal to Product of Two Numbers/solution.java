class Solution {
    public int numTriplets(int[] nums1, int[] nums2) {
        int ans = 0;
        Map<Long, Integer> map = new HashMap();

        for (int num : nums1) {
            long square = (long) num * num;
            map.put(square, map.getOrDefault(square, 0) + 1);
        }

        for (int i = 0; i < nums2.length; i++) {
            for (int j = i + 1; j < nums2.length; j++) {
                long product = (long) nums2[i] * nums2[j];
                ans += map.getOrDefault(product, 0);
            }
        }

        map.clear();

        for (int num : nums2) {
            long square = (long) num * num;
            map.put(square, map.getOrDefault(square, 0) + 1);
        }

        for (int i = 0; i < nums1.length; i++) {
            for (int j = i + 1; j < nums1.length; j++) {
                long product = (long) nums1[i] * nums1[j];
                ans += map.getOrDefault(product, 0);
            }
        }

        return ans;
    }
}