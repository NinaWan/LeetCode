class Solution {
    public int sumOfFlooredPairs(int[] nums) {
        long ans = 0;
        int mod = (int) 1e9 + 7, max = 0;
        int[] freq = new int[200002];

        for (int num : nums) {
            freq[num]++;
            max = Math.max(max, num);
        }

        for (int i = 1; i < freq.length; i++) {
            freq[i] += freq[i - 1];// prefix frequences
        }

        for (int num : nums) {
            int l = num - 1, r = 2 * num - 1, t = 1;
            while (l <= max) {
                ans = (ans + (long) t * (freq[r] - freq[l])) % mod;
                l += num;
                r += num;
                t++;
            }
        }

        return (int) ans;
    }
}