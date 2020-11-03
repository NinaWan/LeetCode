class Solution {
    public int[] frequencySort(int[] nums) {
        int[] ans = new int[nums.length];
        Map<Integer, Integer> freq = new HashMap();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        List<Integer> list = new ArrayList(freq.keySet());
        Collections.sort(list, (a, b) -> {
            if (freq.get(a) == freq.get(b)) {
                return b - a;
            }
            return freq.get(a) - freq.get(b);
        });

        int i = 0;
        for (int num : list) {
            for (int k = 0; k < freq.get(num); k++) {
                ans[i] = num;
                i++;
            }
        }

        return ans;
    }
}