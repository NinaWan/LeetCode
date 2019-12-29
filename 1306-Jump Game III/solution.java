class Solution {
    public boolean canReach(int[] arr, int start) {
        if (arr[start] == 0) {
            return true;
        }

        List<Integer> zeroIndexes = new ArrayList();
        Map<Integer, Set<Integer>> directedGraph = new HashMap();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                zeroIndexes.add(i);
            }

            if (!directedGraph.containsKey(i)) {
                directedGraph.put(i, new HashSet());
            }

            if (i + arr[i] < arr.length) {
                directedGraph.get(i).add(i + arr[i]);
            }

            if (i - arr[i] >= 0) {
                directedGraph.get(i).add(i - arr[i]);
            }
        }

        for (int i = 0; i < zeroIndexes.size(); i++) {
            if (isConnected(start, zeroIndexes.get(i), directedGraph)) {
                return true;
            }
        }

        return false;
    }

    private boolean isConnected(int from, int to, Map<Integer, Set<Integer>> directedGraph) {
        Queue<Integer> queue = new LinkedList();
        Set<Integer> visited = new HashSet();
        visited.add(from);
        for (int next : directedGraph.get(from)) {
            if (!visited.contains(next)) {
                queue.add(next);
                visited.add(next);
            }
        }

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (curr == to) {
                return true;
            }
            for (int next : directedGraph.get(curr)) {
                if (!visited.contains(next)) {
                    queue.offer(next);
                    visited.add(next);
                }
            }
        }

        return false;
    }
}