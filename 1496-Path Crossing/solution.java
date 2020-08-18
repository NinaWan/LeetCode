class Solution {
    public boolean isPathCrossing(String path) {
        Map<Integer, Set<Integer>> visited = new HashMap();
        int[] curr = new int[2];
        visited.put(0, new HashSet(Arrays.asList(0)));

        for (Character c : path.toCharArray()) {
            if (c == 'N') {
                curr[1] += 1;
            } else if (c == 'W') {
                curr[0] -= 1;
            } else if (c == 'S') {
                curr[1] -= 1;
            } else {
                curr[0] += 1;
            }

            if (visited.containsKey(curr[0]) && visited.get(curr[0]).contains(curr[1])) {
                return true;
            } else {
                Set<Integer> set = visited.getOrDefault(curr[0], new HashSet());
                set.add(curr[1]);
                visited.put(curr[0], set);
            }
        }

        return false;
    }
}