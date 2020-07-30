class Solution {
    public int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer, Integer> numOccur = new TreeMap();
        int invalid = 0;

        for (int i = 0; i < nums.length; i++) {
            numOccur.put(nums[i], numOccur.getOrDefault(nums[i], 0) + 1);
            if (numOccur.lastKey() - numOccur.firstKey() > limit) {
                numOccur.put(nums[invalid], numOccur.get(nums[invalid]) - 1);
                if (numOccur.get(nums[invalid]) == 0) {
                    numOccur.remove(nums[invalid]);
                }
                invalid++;
            }
        }

        return nums.length - invalid;
    }
}