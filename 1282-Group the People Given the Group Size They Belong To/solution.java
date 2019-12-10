class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> result = new ArrayList();
        Set<Integer> added = new HashSet();
        for (int i = 0; i < groupSizes.length; i++) {
            if (added.contains(i)) {
                continue;
            }
            List<Integer> group = new ArrayList();
            group.add(i);
            int p = i + 1;
            while (group.size() < groupSizes[i] && p < groupSizes.length) {
                if (groupSizes[p] == groupSizes[i]) {
                    group.add(p);
                    added.add(p);
                }
                p++;
            }

            result.add(group);
        }

        return result;
    }
}