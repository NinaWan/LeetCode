class Solution {
    public boolean canCross(int[] stones) {
        Map<Integer, Set<Integer>> map = new HashMap();// reachable jump units for each stone
        map.put(0, new HashSet(Arrays.asList(1)));
        for (int i = 1; i < stones.length; i++) {
            map.put(stones[i], new HashSet());
        }

        for (int i = 0; i < stones.length; i++) {
            int stone = stones[i];
            for (int k : map.get(stone)) {
                int next = stone + k;

                if (next == stones[stones.length - 1]) {
                    return true;
                }

                if (map.containsKey(next)) {
                    Set<Integer> set = map.get(next);
                    set.add(k);
                    set.add(k + 1);
                    if (k - 1 > 0) {
                        set.add(k - 1);
                    }
                }
            }
        }

        return false;
    }
}