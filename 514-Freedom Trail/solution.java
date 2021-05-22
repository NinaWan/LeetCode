class Solution {
    public int findRotateSteps(String ring, String key) {
        int m = ring.length(), n = key.length();
        int[][] dp = new int[n + 1][m];

        Map<Character, Set<Integer>> map = new HashMap();
        for (int i = 0; i < ring.length(); i++) {
            char c = ring.charAt(i);
            Set<Integer> set = map.getOrDefault(c, new HashSet());
            set.add(i);
            map.put(c, set);
        }

        for (int k = n - 1; k >= 0; k--) {// each character in key
            char target = key.charAt(k);
            for (int i = 0; i < m; i++) {// each possible start position for current rotation
                dp[k][i] = Integer.MAX_VALUE;
                for (int j : map.getOrDefault(target, new HashSet<Integer>())) {// each possbile end position for current rotation
                    int diff = Math.abs(i - j);
                    dp[k][i] = Math.min(dp[k][i], dp[k + 1][j] + Math.min(diff, m - diff));
                }
            }
        }

        return dp[0][0] + n;
    }
}