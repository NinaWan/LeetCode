class Solution {
    public int findLHS(int[] nums) {
        int ans = 0;
        Map<Integer, Integer> freq = new HashMap();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();
            ans = Math.max(ans, val + Math.max(freq.getOrDefault(key + 1, -val), freq.getOrDefault(key - 1, -val)));
        }

        return ans;
    }
}