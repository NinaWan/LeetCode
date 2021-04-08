class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int ans = Integer.MAX_VALUE;
        Map<Integer, Set<Integer>> plMap = new HashMap();
        for (int i = 0; i < languages.length; i++) {
            plMap.put(i + 1, new HashSet<Integer>());
            for (int language : languages[i]) {
                plMap.get(i + 1).add(language);
            }
        }

        boolean[] connected = new boolean[friendships.length];
        for (int i = 0; i < friendships.length; i++) {
            connected[i] = hasCommonLanguage(plMap, friendships[i][0], friendships[i][1]) ? true
                                                                                          : false;
        }

        for (int k = 1; k <= n; k++) {
            Set<Integer> teach = new HashSet();

            for (int i = 0; i < friendships.length; i++) {
                if (connected[i]) {
                    continue;
                }

                if (!(plMap.containsKey(friendships[i][0]) && plMap.get(friendships[i][0]).contains(k))) {
                    teach.add(friendships[i][0]);
                }

                if (!(plMap.containsKey(friendships[i][1]) && plMap.get(friendships[i][1]).contains(k))) {
                    teach.add(friendships[i][1]);
                }
            }

            ans = Math.min(ans, teach.size());
        }

        return ans;
    }

    private boolean hasCommonLanguage(Map<Integer, Set<Integer>> plMap, int u, int v) {
        if (!plMap.containsKey(u) || !plMap.containsKey(v)) {
            return false;
        }

        for (int ul : plMap.get(u)) {
            if (plMap.get(v).contains(ul)) {
                return true;
            }
        }

        return false;
    }
}