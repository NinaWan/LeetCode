class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Map<Integer, Integer> unionCounts = new HashMap();
        int maxCount = 0;
        for (int num : nums) {
            if (!unionCounts.containsKey(num)) {
                int leftCount = unionCounts.getOrDefault(num - 1, 0);
                int rightCount = unionCounts.getOrDefault(num + 1, 0);
                int unionCount = leftCount + rightCount + 1;
                unionCounts.put(num, unionCount);

                // update the count for boundaries of the union set to which current number belongs
                unionCounts.put(num - leftCount, unionCount);
                unionCounts.put(num + rightCount, unionCount);

                maxCount = Math.max(maxCount, unionCount);
            }
        }

        return maxCount;
    }
}