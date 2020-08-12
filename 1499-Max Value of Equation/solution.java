class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        int result = Integer.MIN_VALUE;
        PriorityQueue<Pair<Integer, Integer>> queue = new PriorityQueue<Pair<Integer, Integer>>((e1, e2) -> e1.getKey() == e2.getKey() ? e1.getValue() - e2.getValue() : e2.getKey() - e1.getKey());

        for (int[] point : points) {
            int x = point[0];
            int y = point[1];

            while (!queue.isEmpty() && x - queue.peek().getValue() > k) {
                queue.poll();
            }

            if (!queue.isEmpty()) {
                result = Math.max(result, queue.peek().getKey() + x + y);
            }

            queue.offer(new Pair(y - x, x));
        }

        return result;
    }
}