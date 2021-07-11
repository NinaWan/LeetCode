class Solution {
    public int findRotateSteps(String ring, String key) {
        int m = ring.length(), n = key.length();
        Map<Character, Set<Integer>> charToIndex = new HashMap();
        int[][] memo = new int[m][n];

        for (int i = 0; i < m; i++) {
            charToIndex.computeIfAbsent(ring.charAt(i), HashSet::new).add(i);
        }

        return findRotateSteps(ring, 0, key, 0, charToIndex, memo);
    }

    // minimum steps when ring[i] is at 12 o'clock, input key[j...]
    private int findRotateSteps(String ring, int i, String key, int j, Map<Character, Set<Integer>> charToIndex, int[][] memo) {
        if (j == key.length()) {
            return 0;
        }

        if (memo[i][j] != 0) {
            return memo[i][j];
        }

        int res = Integer.MAX_VALUE, m = ring.length();
        for (int k : charToIndex.get(key.charAt(j))) {
            int diff = Math.abs(k - i);
            res = Math.min(res, 1 + Math.min(diff, m - diff) + findRotateSteps(ring, k, key, j + 1, charToIndex, memo));
        }

        return memo[i][j] = res;
    }
}