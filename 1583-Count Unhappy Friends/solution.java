class Solution {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int ans = 0;
        Map<Integer, Integer> pairMap = new HashMap();

        for (int[] pair : pairs) {
            pairMap.put(pair[0], pair[1]);
            pairMap.put(pair[1], pair[0]);
        }

        for (Map.Entry<Integer, Integer> pair : pairMap.entrySet()) {
            int x = pair.getKey();
            int y = pair.getValue();
            boolean isUnhappy = false;
            for (int u : preferences[x]) {
                if (u == y || isUnhappy) {
                    break;
                }

                int v = pairMap.get(u);
                for (int friend : preferences[u]) {
                    if (friend == v) {
                        break;
                    }

                    if (friend == x) {
                        ans += 1;
                        isUnhappy = true;
                        break;
                    }
                }
            }
        }

        return ans;
    }
}