class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList();

        dfs(s, 0, new ArrayList<String>(), ans);

        return ans;
    }

    private void dfs(String s, int pos, List<String> curr, List<List<String>> res) {
        if (pos == s.length()) {
            res.add(new ArrayList(curr));
            return;
        }

        for (int i = pos; i < s.length(); i++) {
            if (isPalindrome(s, pos, i)) {
                curr.add(s.substring(pos, i + 1));
                dfs(s, i + 1, curr, res);
                curr.remove(curr.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}