class Solution {
    public int minSubarray(int[] nums, int p) {
        int ans = nums.length;
        int remainder = 0;
        for (int num : nums) {
            remainder = (remainder + num) % p;
        }

        if (remainder == 0) {
            return 0;
        }

        Map<Integer, Integer> last = new HashMap();
        last.put(0, -1);

        int curr = 0;
        for (int i = 0; i < nums.length; i++) {
            curr = (curr + nums[i]) % p;
            last.put(curr, i);
            ans = Math.min(ans, i - last.getOrDefault((curr - remainder + p) % p, -nums.length));
        }

        return ans < nums.length ? ans
                                 : -1;
    }
}