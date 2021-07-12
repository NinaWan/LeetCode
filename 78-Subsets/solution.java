class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList();

        backtrack(nums, 0, ans, new ArrayList());

        return ans;
    }

    private void backtrack(int[] nums, int start, List<List<Integer>> res, List<Integer> sub) {
        res.add(new ArrayList(sub));

        if (start >= nums.length) {
            return;
        }

        for (int i = start; i < nums.length; i++) {
            sub.add(nums[i]);
            backtrack(nums, i + 1, res, sub);
            sub.remove(sub.size() - 1);
        }
    }
}