class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return false;
        }

        Map<Integer, Integer> lastIndex = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (!lastIndex.containsKey(nums[i])) {
                lastIndex.put(nums[i], i);
            } else if (i - lastIndex.get(nums[i]) > k) {
                lastIndex.put(nums[i], i);
            } else {
                return true;
            }
        }

        return false;
    }
}