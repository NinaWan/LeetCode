class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList();

        Arrays.sort(candidates);
        dfs(candidates, 0, target, result, new ArrayList());

        return result;
    }

    public void dfs(int[] candidates, int start, int target, List<List<Integer>> result, List<Integer> tempList) {
        if (start > candidates.length - 1 || target < 0) {
            return;
        }

        if (target == 0) {
            result.add(new ArrayList(tempList));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            tempList.add(candidates[i]);
            dfs(candidates, i, target - candidates[i], result, tempList);
            tempList.remove(tempList.size() - 1);
        }
    }
}