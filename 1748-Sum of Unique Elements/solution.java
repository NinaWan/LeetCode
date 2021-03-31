class Solution {
    public int sumOfUnique(int[] nums) {
        int ans = 0;
        Map<Integer, Integer> freq = new HashMap();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            ans += entry.getValue() > 1 ? 0
                                        : entry.getKey();
        }

        return ans;
    }
}