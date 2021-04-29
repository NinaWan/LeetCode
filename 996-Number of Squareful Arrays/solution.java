class Solution {
    public int numSquarefulPerms(int[] A) {
        int ans = 0;
        Map<Integer, Integer> count = new HashMap();
        Map<Integer, Set<Integer>> candidate = new HashMap();

        for (int a : A) {
            count.put(a, count.getOrDefault(a, 0) + 1);
        }

        for (int x : count.keySet()) {
            for (int y : count.keySet()) {
                int s = (int) (Math.sqrt(x + y) + 0.5);
                if (s * s == x + y) {
                    Set<Integer> set = candidate.getOrDefault(x, new HashSet());
                    set.add(y);
                    candidate.put(x, set);
                }
            }
        }

        for (int x : count.keySet()) {
            ans += dfs(x, A.length - 1, count, candidate);
        }

        return ans;
    }

    private int dfs(int x, int remain, Map<Integer, Integer> count, Map<Integer, Set<Integer>> candidate) {
        if (remain == 0) {
            return 1;
        }

        int res = 0;
        count.put(x, count.get(x) - 1);

        for (int y : candidate.getOrDefault(x, new HashSet<Integer>())) {
            if (count.get(y) != 0) {
                res += dfs(y, remain - 1, count, candidate);
            }
        }

        count.put(x, count.get(x) + 1);
        return res;
    }
}