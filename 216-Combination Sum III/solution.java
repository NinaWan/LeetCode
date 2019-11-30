class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList();

        if (k > n || k > 9) {
            return result;
        }

        dfs(k, n, result, new ArrayList(), 1);

        return result;
    }

    public void dfs(int k, int n, List<List<Integer>> result, List<Integer> tempList, int num) {
        if (n == 0 && k == 0) {
            result.add(new ArrayList(tempList));
            return;
        }

        for (int i = num; i <= 9; i++) {
            tempList.add(i);
            dfs(k - 1, n - i, result, tempList, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}