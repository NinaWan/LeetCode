class Solution {
    public int numIdenticalPairs(int[] nums) {
        int result = 0;
        Map<Integer, Integer> freq = new HashMap();

        for (int num : nums) {
            int exist = freq.getOrDefault(num, 0);
            result += exist;
            freq.put(num, exist + 1);
        }

        return result;
    }
}