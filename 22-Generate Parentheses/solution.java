class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        backtrack(ans, n, n, "");
        return ans;
    }

    private void backtrack(List<String> res, int left, int right, String curr) {
        if (right < left || left < 0 || right < 0) {
            return;
        }

        if (left == 0 && right == 0) {
            res.add(curr);
            return;
        }

        curr += "(";
        backtrack(res, left - 1, right, curr);
        curr = curr.substring(0, curr.length() - 1);

        curr += ")";
        backtrack(res, left, right - 1, curr);
        curr = curr.substring(0, curr.length() - 1);
    }
}