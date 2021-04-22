class Solution {
    public String crackSafe(int n, int k) {
        StringBuilder ans = new StringBuilder();
        Set<String> visited = new HashSet();

        if (n == 1 && k == 1) {
            return "0";
        }

        String start = "";
        for (int i = 0; i < n - 1; i++) {
            start += "0";
        }

        dfs(start, k, ans, visited);
        ans.append(start);

        return ans.toString();
    }

    private void dfs(String node, int k, StringBuilder ans, Set<String> visited) {
        for (int i = 0; i < k; i++) {
            String next = node + i;
            if (!visited.contains(next)) {
                visited.add(next);
                dfs(next.substring(1), k, ans, visited);
                ans.append(i);
            }
        }
    }
}