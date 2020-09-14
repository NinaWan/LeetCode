class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        int ans = 0;
        List<Set<Integer>> rows = new ArrayList();
        Map<Integer, Integer> freq = new HashMap();
        int max = 0;
        int line = 0;

        for (List<Integer> row : wall) {
            int sum = 0;
            Set<Integer> set = new HashSet();
            for (int i = 0; i < row.size(); i++) {
                sum += row.get(i);
                set.add(sum);
                if (i != row.size() - 1) {
                    freq.put(sum, freq.getOrDefault(sum, 0) + 1);
                    if (freq.get(sum) > max) {
                        max = freq.get(sum);
                        line = sum;
                    }
                }
            }
            rows.add(set);
        }

        for (Set<Integer> row : rows) {
            if (!row.contains(line)) {
                ans++;
            }
        }

        return ans;
    }
}