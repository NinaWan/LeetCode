class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList();
        int n1 = nums1.length;
        int n2 = nums2.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        for (int i = 0, j = 0; i < n1 && j < n2; ) {
            if (nums1[i] == nums2[j]) {
                int curr = nums1[i];
                int c1 = 0;
                int c2 = 0;
                while (i < n1 && nums1[i] == curr) {
                    c1++;
                    i++;
                }

                while (j < n2 && nums2[j] == curr) {
                    c2++;
                    j++;
                }

                for (int k = 0; k < Math.min(c1, c2); k++) {
                    list.add(curr);
                }
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }

        int[] ans = new int[list.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }
}