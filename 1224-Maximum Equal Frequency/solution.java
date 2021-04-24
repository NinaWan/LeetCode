class Solution {
    public int maxEqualFreq(int[] nums) {
        int ans = 0;
        Map<Integer, Integer> freq = new HashMap();
        Map<Integer, Integer> freqCount = new HashMap();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int f = freq.getOrDefault(num, 0) + 1;
            freq.put(num, f);
            freqCount.put(f, freqCount.getOrDefault(f, 0) + 1);

            int count = freqCount.get(f) * f;
            if (count == i + 1 && i < nums.length - 1) {// delete current number
                ans = Math.max(ans, i + 2);
            } else if (count == i) {// keep current number
                ans = Math.max(ans, i + 1);
            }
        }

        return ans;
    }
}