class Solution {
    public int countPairs(int[] deliciousness) {
        long ans = 0;
        int mod = (int) 1e9 + 7;
        Map<Integer, Integer> freq = new HashMap();

        for (int d : deliciousness) {
            int target = 1;
            for (int i = 0; i < 22; i++) {
                ans += freq.getOrDefault(target - d, 0);
                ans %= mod;
                target *= 2;
            }

            freq.put(d, freq.getOrDefault(d, 0) + 1);
        }

        return (int) ans;
    }
}