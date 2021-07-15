class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> presum = new HashMap();
        presum.put(0, 1);

        int sum = 0, ans = 0;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            ans += presum.getOrDefault(sum - k, 0);
            presum.put(sum, presum.getOrDefault(sum, 0) + 1);
        }

        return ans;
    }
}