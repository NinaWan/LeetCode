class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length, ans = 0, maxLen = 0;
        int[] count = new int[n];// the number of the LIS ending with nums[i]
        int[] len = new int[n];// the length of the LIS ending with nums[i]

        for (int i = 0; i < n; i++) {
            count[i] = len[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (len[i] < len[j] + 1) {
                        len[i] = len[j] + 1;
                        count[i] = count[j];
                    } else if (len[i] == len[j] + 1) {
                        count[i] += count[j];
                    }
                }
            }

            if (len[i] > maxLen) {
                maxLen = len[i];
                ans = count[i];
            } else if (len[i] == maxLen) {
                ans += count[i];
            }
        }

        return ans;
    }
}