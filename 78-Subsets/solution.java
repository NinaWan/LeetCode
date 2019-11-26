class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<List<Integer>>();
        }

        List<List<Integer>> result = new ArrayList();
        List<Integer> tempList = new ArrayList();

        dfs(nums, 0, nums.length - 1, result, tempList);

        return result;
    }

    public void dfs(int[] nums, int start, int end, List<List<Integer>> result, List<Integer> tempList) {
        result.add(new ArrayList<Integer>(tempList));

        if (start > end) {
            return;
        }

        for (int i = start; i <= end; i++) {
            tempList.add(nums[i]);
            dfs(nums, i + 1, end, result, tempList);
            tempList.remove(tempList.size() - 1);
        }
    }
}