class Solution {
    public int minAbsDifference(int[] nums, int goal) {
        int ans = Math.abs(goal);
        Set<Integer> left = new HashSet();
        Set<Integer> right = new HashSet();

        generateSubsums(nums, 0, nums.length / 2, 0, left);
        generateSubsums(nums, nums.length / 2, nums.length, 0, right);

        TreeSet<Integer> treeSet = new TreeSet(right);
        for (Integer subsum : left) {
            Integer floor = treeSet.floor(goal - subsum);
            Integer ceiling = treeSet.ceiling(goal - subsum);
            if (floor != null) {
                ans = Math.min(ans, Math.abs(subsum + floor - goal));
            }
            if (ceiling != null) {
                ans = Math.min(ans, Math.abs(subsum + ceiling - goal));
            }
        }

        return ans;
    }

    private void generateSubsums(int[] nums, int start, int end, int sum, Set<Integer> result) {
        if (start == end) {
            result.add(sum);
            return;
        }

        generateSubsums(nums, start + 1, end, sum, result);// exclude nums[start]
        generateSubsums(nums, start + 1, end, sum + nums[start], result);// include nums[start]
    }
}