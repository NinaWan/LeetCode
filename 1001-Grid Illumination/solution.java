class Solution {
    public int[] gridIllumination(int N, int[][] lamps, int[][] queries) {
        int[] ans = new int[queries.length];
        Map<Integer, Integer> row = new HashMap(), col = new HashMap();
        Map<Integer, Integer> left = new HashMap(), right = new HashMap(); // diagonal x-y and x+y
        Map<Integer, Set<Integer>> lampMap = new HashMap();

        for (int i = 0; i < lamps.length; i++) {
            int x = lamps[i][0];
            int y = lamps[i][1];
            Set<Integer> set = lampMap.getOrDefault(x, new HashSet());
            if (!set.contains(y)) {
                set.add(y);
                row.put(x, row.getOrDefault(x, 0) + 1);
                col.put(y, col.getOrDefault(y, 0) + 1);
                left.put(x - y, left.getOrDefault(x - y, 0) + 1);
                right.put(x + y, right.getOrDefault(x + y, 0) + 1);
            }
            lampMap.put(x, set);
        }

        for (int m = 0; m < queries.length; m++) {
            int x = queries[m][0];
            int y = queries[m][1];

            if (row.getOrDefault(x, 0) > 0 || col.getOrDefault(y, 0) > 0 || left.getOrDefault(x - y, 0) > 0 || right.getOrDefault(x + y, 0) > 0) {
                ans[m] = 1;

                for (int i = x - 1; i <= x + 1; i++) {
                    for (int j = y - 1; j <= y + 1; j++) {
                        if (lampMap.containsKey(i)) {
                            Set<Integer> set = lampMap.get(i);
                            if (set.contains(j)) {
                                set.remove(j);
                                row.put(i, row.getOrDefault(i, 1) - 1);
                                col.put(j, col.getOrDefault(j, 1) - 1);
                                left.put(i - j, left.getOrDefault(i - j, 1) - 1);
                                right.put(i + j, right.getOrDefault(i + j, 1) - 1);
                            }
                            lampMap.put(i, set);
                        }
                    }
                }
            }
        }

        return ans;
    }
}