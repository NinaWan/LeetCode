class Solution {
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> freq = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int product = nums[i] * nums[j];
                freq.put(product, freq.getOrDefault(product, 0) + 1);
            }
        }

        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int count = entry.getValue();
            if (count > 1) {
                ans += count * (count - 1) * 4;
            }
        }

        return ans;
    }
}