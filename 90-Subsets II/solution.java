class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList();

        if (nums == null || nums.length == 0) {
            return result;
        }

        Arrays.sort(nums);
        dfs(nums, 0, result, new ArrayList());

        return result;
    }

    public void dfs(int[] nums, int start, List<List<Integer>> result, List<Integer> tempList) {

        result.add(new ArrayList(tempList));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            tempList.add(nums[i]);
            dfs(nums, i + 1, result, tempList);
            tempList.remove(tempList.size() - 1);
        }
    }
}