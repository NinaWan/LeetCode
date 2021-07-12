class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList();
        backtrack(n, k, 1, ans, new ArrayList());
        return ans;
    }

    private void backtrack(int n, int k, int start, List<List<Integer>> res, List<Integer> comb) {
        if (comb.size() == k) {
            res.add(new ArrayList(comb));
            return;
        }

        for (int i = start; i <= n; i++) {
            comb.add(i);
            backtrack(n, k, i + 1, res, comb);
            comb.remove(comb.size() - 1);
        }
    }
}