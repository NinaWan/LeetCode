class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] ans = new int[k];
        Map<Integer, Set<Integer>> map = new HashMap();
        for (int[] log : logs) {
            Set<Integer> set = map.getOrDefault(log[0], new HashSet());
            set.add(log[1]);
            map.put(log[0], set);
        }

        for (Set<Integer> value : map.values()) {
            ans[value.size() - 1]++;
        }

        return ans;
    }
}