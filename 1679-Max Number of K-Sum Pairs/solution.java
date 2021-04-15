class Solution {
    public int maxOperations(int[] nums, int k) {
        int ans = 0;
        Map<Integer, Integer> count = new HashMap();

        for (int num : nums) {
            int key = k - num;
            if (count.containsKey(key) && count.get(key) > 0) {
                count.put(key, count.get(key) - 1);
                ans++;
            } else {
                count.put(num, count.getOrDefault(num, 0) + 1);
            }
        }

        return ans;
    }
}