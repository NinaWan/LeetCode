class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int[] preSum = new int[arr.length];
        int ans = 0;

        for (int i = 0; i < arr.length; i++) {
            ans += arr[i];
            preSum[i] = ans;
        }

        for (int n = 3; n - 1 < arr.length; n += 2) {
            ans += preSum[n - 1];
            for (int i = 0; i < arr.length; i++) {
                if (i + n < arr.length) {
                    ans += preSum[i + n] - preSum[i];
                }
            }
        }

        return ans;
    }
}