class Solution {
    public int numTimesAllBlue(int[] light) {
        int result = 0;
        PriorityQueue<Integer> queue = new PriorityQueue(Collections.reverseOrder());

        for (int l : light) {
            queue.offer(l);
            if (queue.peek() == queue.size()) {
                result++;
            }
        }

        return result;
    }
}