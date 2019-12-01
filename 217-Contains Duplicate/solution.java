class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }

        Set<Integer> set = new HashSet();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }

        return false;
    }
}