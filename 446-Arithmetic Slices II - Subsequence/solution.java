class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int ans = 0;
        Map<Integer, Integer>[] dp = new Map[nums.length];// dp[i,d] - number of arithmetics slices end at i with diff d

        for (int j = 0; j < nums.length; j++) {
            dp[j] = new HashMap(j);

            for (int i = 0; i < j; i++) {
                long diff = (long) nums[j] - nums[i];
                if (diff <= Integer.MIN_VALUE || diff >= Integer.MAX_VALUE) {
                    continue;
                }

                int counti = dp[i].getOrDefault((int) diff, 0);
                int countj = dp[j].getOrDefault((int) diff, 0);
                ans += counti;

                dp[j].put((int) diff, countj + counti + 1);
            }
        }

        return ans;
    }
}