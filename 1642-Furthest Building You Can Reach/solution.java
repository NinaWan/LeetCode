class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> queue = new PriorityQueue();
        int brickNeeded = 0, i = 0;
        for (; i < heights.length - 1; i++) {
            if (heights[i] <= heights[i + 1]) {
                queue.offer(heights[i + 1] - heights[i]);
                if (queue.size() > ladders) {
                    brickNeeded += queue.poll();
                }
                if (brickNeeded > bricks) {
                    break;
                }
            }
        }

        return i;
    }
}