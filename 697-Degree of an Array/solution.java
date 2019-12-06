class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> count = new HashMap();
        Map<Integer, Integer> leftFirstIdx = new HashMap();
        Map<Integer, Integer> rightFirstIdx = new HashMap();

        for (int i = 0; i < nums.length; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
            rightFirstIdx.put(nums[i], i);
            if (!leftFirstIdx.containsKey(nums[i])) {
                leftFirstIdx.put(nums[i], i);
            }
        }

        int degree = Collections.max(count.values());
        int result = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (entry.getValue() == degree) {
                result = Math.min(result, rightFirstIdx.get(entry.getKey()) - leftFirstIdx.get(entry.getKey()) + 1);
            }
        }

        return result;
    }
}