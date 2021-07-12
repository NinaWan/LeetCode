class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        backtrack(nums, new LinkedHashSet(), ans);
        return ans;
    }

    private void backtrack(int[] nums, LinkedHashSet<Integer> perm, List<List<Integer>> res) {
        if (perm.size() == nums.length) {
            res.add(new ArrayList(perm));
            return;
        }

        for (int num : nums) {
            if (perm.contains(num)) {
                continue;
            }

            perm.add(num);
            backtrack(nums, perm, res);
            perm.remove(num);
        }
    }
}