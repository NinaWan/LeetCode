class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int ans = 0;
        List<Integer> list = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) {
                list.add(i);
            }
        }

        int left = 0;
        int right = 0;

        while (right < list.size()) {
            if (right - left + 1 < k) {
                right++;
            }

            if (right - left + 1 == k) {
                int a = left == 0 ? list.get(left) + 1
                                  : list.get(left) - list.get(left - 1);
                int b = right == list.size() - 1 ? nums.length - list.get(right)
                                                 : list.get(right + 1) - list.get(right);
                ans += a * b;
                left++;
                right++;
            }
        }

        return ans;
    }
}