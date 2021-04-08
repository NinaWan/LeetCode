class Solution {
    public int countNicePairs(int[] nums) {
        long ans = 0;
        Map<Integer, Integer> freq = new HashMap();
        Map<Integer, Integer> revMap = new HashMap();

        for (int num : nums) {
            revMap.computeIfAbsent(num, k -> num - rev(k));
            int key = revMap.get(num);
            freq.put(key, freq.getOrDefault(key, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            long count = (long) entry.getValue();
            ans += count * (count - 1) / 2 % (1e9 + 7);
            ans %= (1e9 + 7);
        }

        return (int) ans;
    }

    private int rev(int num) {
        int ans = 0;
        while (num != 0) {
            ans = ans * 10 + num % 10;
            num = num / 10;
        }

        return ans;
    }
}