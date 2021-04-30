class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int ans = 0, sum = 0, n = nums.length;
        Set<Integer> seen = new HashSet();

        for (int l = 0, r = 0; l < n; l++) {
            while (r < n && !seen.contains(nums[r])) {
                seen.add(nums[r]);
                sum += nums[r];
                r++;
            }

            ans = Math.max(ans, sum);
            sum -= nums[l];
            seen.remove(nums[l]);
        }

        return ans;
    }
}