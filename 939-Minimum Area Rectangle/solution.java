class Solution {
    public int minAreaRect(int[][] points) {
        int ans = Integer.MAX_VALUE;
        Map<Integer, Set<Integer>> xMap = new HashMap();
        for (int[] point : points) {
            Set<Integer> set = xMap.getOrDefault(point[0], new HashSet());
            set.add(point[1]);
            xMap.put(point[0], set);
        }

        List<Integer> xs = new ArrayList(xMap.keySet());
        for (int i = 0; i < xs.size(); i++) {
            for (int j = i + 1; j < xs.size(); j++) {
                int x1 = xs.get(i);
                int x2 = xs.get(j);

                PriorityQueue<Integer> queue = new PriorityQueue();
                Set<Integer> y2s = xMap.get(x2);
                for (int y1 : xMap.get(x1)) {
                    if (y2s.contains(y1)) {
                        queue.offer(y1);
                    }
                }

                if (queue.size() < 2) {
                    continue;
                }

                int curr = queue.poll();
                int minYDist = Integer.MAX_VALUE;
                while (!queue.isEmpty()) {
                    minYDist = Math.min(minYDist, queue.peek() - curr);
                    curr = queue.poll();
                }

                ans = Math.min(ans, Math.abs(x1 - x2) * minYDist);
            }
        }

        return ans == Integer.MAX_VALUE ? 0
                                        : ans;
    }
}