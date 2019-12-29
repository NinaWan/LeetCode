class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList();

        dfs(result, n, n, "");

        return result;
    }

    private void dfs(List<String> result, int left, int right, String temp) {
        if (left == 0 && right == 0) {
            result.add(temp);
            return;
        }

        if (left != 0) {
            temp += "(";
            dfs(result, left - 1, right, temp);
            temp = temp.substring(0, temp.length() - 1);
        }

        if (right != 0 && right > left) {
            temp += ")";
            dfs(result, left, right - 1, temp);
            temp = temp.substring(0, temp.length() - 1);
        }
    }
}